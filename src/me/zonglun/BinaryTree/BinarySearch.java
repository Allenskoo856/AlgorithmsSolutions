/*
 * Copyright (C), 2015-2017
 * FileName: BinarySearch
 * Author:   Administrator
 * Date:     2017/11/7 0007 21:30
 * Description: BinarySearch 二分查找算法    
 */

package me.zonglun.BinaryTree;

/**
 * 〈一句话功能简述〉<br>
 * 〈BinarySearch 二分查找算法〉
 *
 * @author Administrator
 * @create 2017/11/7 0007
 * @since 1.0.0
 */
public class BinarySearch {
    private BinarySearch() {
    }

    // 二分查找法,在有序数组arr中,查找target (值不是索引)
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target) {
        // 在arr[l...r]之中查找target
        int l = 0, r = arr.length - 1;
        while (l <= r) {    // l 和 r 为索引意味着当 l = r 的时候说明这时候
            // int mid = (l + r) / 2;
            int mid = l + (r - l) / 2;
            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            if (arr[mid].compareTo(target) == 0)
                return mid;
            // 说明 target 在 mid 的左半部分, 此时在arr【l， mid - 1】之中再次循环
            if (arr[mid].compareTo(target) > 0)
                r = mid - 1;
            else    // 说明 target 在 mid 的右半部分 ，此时在arr【mid + 1，r】 之中再次循环
                l = mid + 1;
        }
        return -1;
    }

    // 测试非递归的二分查找算法
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;
        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch.find(arr, i);
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }
    }
}
