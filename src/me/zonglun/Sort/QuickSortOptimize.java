/*
 * Copyright (C), 2015-2017
 * FileName: QuickSortOptimize
 * Author:   Administrator
 * Date:     2017/11/4 0004 14:07
 * Description: optimize  the quickSort    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈optimize  the quickSort〉
 *
 * @author Administrator
 * @create 2017/11/4 0004
 * @since 1.0.0
 */
public class QuickSortOptimize {
    private QuickSortOptimize() {
    }

    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l); // 随机生成 l-r 之间的索引

        Comparable v = arr[l];
        int j = l;      // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(v) < 0) {
                swap(arr, j + 1, i);
                j++;
            }
        swap(arr, l, j);
        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (r < l)
            return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.QuickSortOptimize", arr);

        // 测试2 测试近乎有序的数组
        int swapTime  = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTime);

        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTime);
        SortTestHelper.testSort("me.zonglun.Sort.QuickSortOptimize", arr1);
    }
}
