/*
 * Copyright (C), 2015-2017
 * FileName: ReOrderArray
 * Author:   Administrator
 * Date:     2017/11/23 0023 22:21
 * Description: 调整数组顺序使得奇数位于偶数前面    
 */

package me.zonglun.SwordToOffer;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈调整数组顺序使得奇数位于偶数前面〉
 *
 * @author Administrator
 * @subject     输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *              使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 *              并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @create 2017/11/23 0023
 * @since 1.0.0
 */
public class ReOrderArray {

    /**
     * 要求是有序的数组 c此时的平均复杂度为o(n^2)
     * @param array array
     */
    private static void reOrderArray(int[] array) {
        // 相对位置不变
        // 插入排序
        int count = 0; // count 是用来记录已经摆好位置的奇数的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > count) {     // 当前奇数的索引与count比较，比count小则证明已经排队好了，不用再比较了
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    j--;
                }
                count++;
            }
        }
    }

    /**
     * 首先统计奇数的个数
        然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
     * @param array
     */
    private static void reOrderArray2(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int oddCount = 0, oddBegin = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddCount++; // 记录原来数组中的奇数的数量
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                newArray[oddBegin++] = array[i];
            } else {
                newArray[oddCount++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i]; // 再把原数组覆盖掉
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 8, 2, 13, 21};
        // reOrderArray(arr);
        // System.out.println(Arrays.toString(arr));
        reOrderArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
