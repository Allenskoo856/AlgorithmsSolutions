package me.zonglun.Sort;


/*
 *  1. 选择排序(Selection-sort)是一种简单直观的排序算法。
 *  	它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 *  	然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 * 	2. 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
		第二次遍历n-2个数，找到最小的数值与第二个元素交换；。。。。。
		第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
 * */
public class SelectionSort {
    private  SelectionSort () {}

    // 交换索引为i ；和 j的两个数组的值
    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 找到【i，n）之间的最小值的索引
            int minIndex = i; // 最开始的最小索引定为 开始的 i
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo( arr[minIndex]) < 0)  // 判断i之后的每个值，如果有值比其小，则最小索引改变
                    minIndex = j;
            }
            swap(arr, i, minIndex);		// 内层循环完之后交换最小索引与i的值，同时i指针前移动一位
        }
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        long startTime = System.currentTimeMillis();
        SelectionSort.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(  " SelectionSort sort for 100000 Random Numbers: " + (endTime-startTime) + "ms" );
    }

}