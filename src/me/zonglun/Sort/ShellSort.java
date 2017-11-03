/*
 * Copyright (C), 2015-2017
 * FileName: ShellSort
 * Author:   Administrator
 * Date:     2017/11/3 0003 14:56
 * Description:  ShellSort    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈 ShellSort〉
 * 希尔排序的核心在于间隔序列的设定。
 * 既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版》的合著者Robert Sedgewick提出的。
 * <1>. 选择一个增量序列t1，t2，…，tk，其中ti > tj，tk = 1；
 * <2>. 按增量序列个数k， 对序列进行k 趟排序 ；
 * <3>.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为 m 的子序列，
 * 分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度.
 *      最佳情况：T(n) = O(n（log n）^2)
         最坏情况：T(n) = O(n（log n）^2)
         平均情况：T(n) =O(nlogn)
 * @author Administrator
 * @create 2017/11/3 0003
 * @since 1.0.0
 */
public class ShellSort {
    private ShellSort() {
    }

    public static void sort(Comparable<Object>[] arr) {
        int n = arr.length;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;  // h记为增量
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort("me.zonglun.Sort.ShellSort", arr1);
    }
}
