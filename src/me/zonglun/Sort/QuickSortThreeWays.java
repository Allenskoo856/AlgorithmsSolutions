/*
 * Copyright (C), 2015-2017
 * FileName: QuickSortThreeWays
 * Author:   Administrator
 * Date:     2017/11/4 0004 21:29
 * Description:     
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/213055332.png)
 * ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/213139021.png)
 * ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/213358385.png)
 * ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/213816213.png)
 *
 * @author Administrator
 * @create 2017/11/4 0004
 * @since 1.0.0
 */
public class QuickSortThreeWays {
    private QuickSortThreeWays() {
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    // 测试 QuickSort3Ways
    public static void main(String[] args) {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.QuickSortThreeWays", arr);

        // 测试2 测试近乎有序的数组
        int swapTime = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTime);

        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        SortTestHelper.testSort("me.zonglun.Sort.QuickSortThreeWays", arr1);
    }
}
