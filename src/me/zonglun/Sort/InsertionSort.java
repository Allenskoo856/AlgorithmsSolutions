/*
 * Copyright (C), 2015-2017
 * FileName: InsertionSort
 * Author:   Administrator
 * Date:     2017/11/3 0003 10:36
 * Description: InsertionSort    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 1. 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
 * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * <1>.从第一个元素开始，该元素可以认为已经被排序；
 * <2>.取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * <3>.如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * <4>.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * <5>.将新元素插入到该位置后；
 * <6>.重复步骤2~5。
 * you can see more detail in   https://blog.zonglun.me/?p=140
 *  时间复杂度为o(N*2)
 * @author Administrator
 * @create 2017/11/3 0003
 * @since 1.0.0
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            /*从后往前面扫，如果有小的就交换*/
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    // 交换索引为i ；和 j的两个数组的值
    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.InsertionSort", arr);
    }
}
