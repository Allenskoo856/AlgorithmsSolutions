/*
 * Copyright (C), 2015-2017
 * FileName: QuickSort
 * Author:   Administrator
 * Date:     2017/11/3 0003 16:29
 * Description: QuickSort     
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈QuickSort 〉
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
 * 其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * <1>.从数列中挑出一个元素，称为 “基准”（pivot）；
 * <2>.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * <3>.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * @author Administrator
 * @create 2017/11/3 0003
 * @since 1.0.0
 */
public class QuickSort {
    private QuickSort() {
    }

    // 对arr[l...r]部分进行partition操作
    //  arr: l --- p-1 -- p -- p+1 -----r  保证前两部分呢都排好序
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        /*  图示数组：  v | ---  <V --- | --- >V ---| e
        *
        *   索引       l | ---  ------|j|-------| i
        * */
        Comparable v = arr[l]; // 最开始的值
        // 取J 作为分割两边的 中间点
        int j = l;      // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)        // 当前正在访问的索引值记为 i
            if (arr[i].compareTo(v) < 0) {  // 如果当前元素比第一个值要下，则将其放到前半部分的最后一个元素，然后 j 后移一位
                swap(arr, j + 1, i);
                j++;
            }   // 如果当前元素比第一个值要大，则将其放到后半部分的最后位置，此时不用做啥，i后移一位即可
        swap(arr, l, j);    // 前面排序完成之后，将 V 和 J 的值交换位置
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.QuickSort", arr);
    }

}
