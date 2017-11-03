package me.zonglun.Sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 1. 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * <1>.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * <2>.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * <3>.针对所有的元素重复以上的步骤，除了最后一个；
 * <4>.重复步骤1~3，直到排序完成。
 * you can see more detail in   https://blog.zonglun.me/?p=140
 * 平均时间复杂度为o(N*2)
 *
 * @author Administrator
 * @create 2017/11/3 0003
 * @since 1.0.0
 */
public class BubbleSort {
    private BubbleSort() {}

    public static void sort(Comparable<Object>[] arr) {
        int n = arr.length;
        int newn;
        do {
            newn = 0;
            for (int  i = 1; i < n; i++) {
                if (arr[i -1].compareTo( arr[i]) > 0) {
                    swap(arr , i - 1, i);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n = newn;
        }while (newn > 0);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("me.zonglun.Sort.SelectionSort", arr1);
        SortTestHelper.testSort("me.zonglun.Sort.InsertionSort", arr2);
        SortTestHelper.testSort("me.zonglun.Sort.BubbleSort", arr3);

        System.out.println();
    }
}
