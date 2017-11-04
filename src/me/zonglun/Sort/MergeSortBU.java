/*
 * Copyright (C), 2015-2017
 * FileName: MergeSortBU
 * Author:   Administrator
 * Date:     2017/11/3 0003 21:49
 * Description: 自顶向上的归并排序，不需要递归调用    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈自顶向上的归并排序，不需要递归调用〉
 *
 * @author Administrator
 * @create 2017/11/3 0003
 * @since 1.0.0
 */
public class MergeSortBU {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size *= 2)
            for (int i = 0; i < n - size; i += size + size)
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + size - 1, Math.min(i + 2 * size - 1, n - 1));
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        MergeSort.merge(arr, l, mid, r);
    }

    // 测试 MergeSort BU
    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.MergeSortBU", arr);
    }
}
