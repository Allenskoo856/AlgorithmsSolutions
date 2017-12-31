/*
 * Copyright (C), 2015-2017
 * FileName: ReOrderArray
 * Author:   Administrator
 * Date:     2017/11/23 0023 22:21
 * Description: 调整数组顺序使得奇数位于偶数前面    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈调整数组顺序使得奇数位于偶数前面〉
 *
 * @author Administrator
 * @subject 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @create 2017/11/23 0023
 * @since 1.0.0
 */
public class ReOrderArray {

    public static int[] reOrderArray(int[] array) {
        if (array.length == 0 || array.length == 1) return null;
        //相对位置不变，稳定性
        //插入排序的思想
        int k = 0; // 记录已经摆好的基数的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j >= 1 && array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = array[i];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 1, 68, 21, 34, 9};
        int[] aferArr = ReOrderArray.reOrderArray(arr);
        for (int i = 0; i < aferArr.length; i++) {
            System.out.print(aferArr[i] + " ");
        }
    }
}
