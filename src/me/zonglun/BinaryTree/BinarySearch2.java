/*
 * Copyright (C), 2015-2017
 * FileName: BinarySearch2
 * Author:   Administrator
 * Date:     2017/11/7 0007 21:51
 * Description: 递归版本的二分查找算法    
 */

package me.zonglun.BinaryTree;

import me.zonglun.Sort.InsertionSort;

/**
 * 〈一句话功能简述〉<br>
 * 〈递归版本的二分查找算法〉
 *
 * @author Administrator
 * @create 2017/11/7 0007
 * @since 1.0.0
 */
public class BinarySearch2 {
    private BinarySearch2() {
    }

    private static int find(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0)
            return mid;
        else if (arr[mid].compareTo(target) < 0)
            return find(arr, mid + 1, r, target);
        else
            return find(arr, l, mid - 1, target);
    }

    public static int find(Comparable[] arr, Comparable target) {
        return find(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {
        Comparable[] arr = {4, 6, 2, 1, 7, 12, 78, 94, 123, 11};
        InsertionSort.sort(arr);
        System.out.println(BinarySearch2.find(arr, 11));
    }
}
