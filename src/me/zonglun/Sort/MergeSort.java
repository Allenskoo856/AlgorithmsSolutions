/*
 * Copyright (C), 2015-2017
 * FileName: MergeSort
 * Author:   Administrator
 * Date:     2017/11/3 0003 15:18
 * Description: MergeSort    
 */

package me.zonglun.Sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈MergeSort〉
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * <1>.把长度为n的输入序列分成两个长度为n/2的子序列；<br>
 * <2>.对这两个子序列分别采用归并排序；            <br>
 * <3>.将两个排序好的子序列合并成一个最终的排序序列。 <br>
 * 时间复杂度o（nlogn） 但是需要多开辟临时空间 o（n）
 *
 * @author Administrator
 * @create 2017/11/3 0003
 * @since 1.0.0
 */
public class MergeSort {
    private MergeSort() {
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        // 创建额外大小的空间的数组用来归并两边已经排好序的 半 数组
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {      // K 的指针是额外数组的索引指针


            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];    // 此时右边值已经有序了，直接赋值给arr【k】即可
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];     // 同理
                i++;
                /*特别注意额外空间的索引值不一样，aux的索引必须为 i - l 代表左边部分元素
                  aux： 0 1 2  3 4 5 6 7 8  9
                            i   mid      j
                  arr:  l
                        (K)--指针移动来排序
                ，应为其中有错开*/
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.MergeSort", arr);
    }
}
