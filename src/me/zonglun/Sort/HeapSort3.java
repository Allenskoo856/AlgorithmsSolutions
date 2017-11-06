/*
 * Copyright (C), 2015-2017
 * FileName: HeapSort3
 * Author:   Administrator
 * Date:     2017/11/6 0006 20:08
 * Description: HeapSort3 原地堆排序    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈HeapSort3 原地堆排序〉
 *
 * @author Administrator
 * @create 2017/11/6 0006
 * @since 1.0.0
 */
public class HeapSort3 {
    private HeapSort3() {
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 原始的shiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k) {

        while (2 * k + 1 < n) {     // 左孩子不越界
            int j = 2 * k + 1;      // 初始值为 2k + 1；
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j += 1;

            if (arr[k].compareTo(arr[j]) >= 0) break;

            swap(arr, k, j);
            k = j;
        }
    }

    // 优化的shiftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void shiftDown2(Comparable[] arr, int n, int k) {

        Comparable e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j += 1;

            if (e.compareTo(arr[j]) >= 0)
                break;

            arr[k] = arr[j];
            k = j;
        }

        arr[k] = e;
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            shiftDown2(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);        // 当前最大的元素放到合适的位置之中
            shiftDown2(arr, i, 0);  // 对第零个元素进行测试
        }
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.HeapSort3", arr);
    }
}
