package me.zonglun.leetcode.Algorithms;

import java.util.Stack;

/**
 * 基数排序
 *
 * @author : Administrator
 * @create 2018-09-04 15:33
 * @subject :
 *      基数排序(radix sort)属于"分配式排序"(distribution sort)，又称"桶子法"(bucket sort)或bin sort，顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些"桶"中，
 *      藉以达到排序的作用，基数排序法是属于稳定性的排序，其时间复杂度为O (nlog(r)m)，
 *      其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 */
public class CardinalitySort {


    /**
     * 递归找出数组最大的值为多少，
     * @param array 数组
     * @param L
     * @param R
     * @return
     */
    private static int findMax(int[] array, int L, int R) {
        if (L == R) {
            return array[L];
        } else {
            int a = array[L];
            int b = findMax(array, L + 1, R);
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }

    public static void radixSort(int[] arrays) {
        int max = findMax(arrays, 0, arrays.length - 1);
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] bucketes = new int[arrays.length][10];
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                // 将其放入桶中
                bucketes[j][num] = arrays[j];
            }
            int k = 10;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < arrays.length; l++) {
                    if (bucketes[l][j] != 0) {
                        arrays[k++] = bucketes[l][i];
                    }
                }
            }
        }
    }
}
