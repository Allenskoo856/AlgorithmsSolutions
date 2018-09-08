/*
 * Copyright (C), 2015-2017
 * FileName: RadixSort
 * Author:   Administrator
 * Date:     2017/11/6 0006 21:50
 * Description: 基数排序    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈基数排序〉
 * 相对于常见的比较排序，基数排序是一种分配式排序，即通过将所有数字分配到应在的位置最后再覆盖到原数组完成排序的过程。
 *
 * @author Administrator
 * @create 2017/11/6 0006
 * @since 1.0.0
 */
public class RadixSort {
    private RadixSort() {
    }

    public static void main(String[] args) {
        int[] A = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        RadixSort.sort(A, 100);
        for (int num : A) {
            System.out.println(num);
        }

        int N = 1000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
        SortTestHelper.testSort("me.zonglun.Sort.RadixSort", arr);
    }

    private static void sort(int[] arr, int d) {
        int n = 1;  //代表位数对应的数：1,10,100...
        int k = 0;  //保存每一位排序后的结果用于下一位的排序输入
        int len = arr.length;
        int[][] bucket = new int[10][len];  //排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order = new int[len];//用于保存每个桶里有多少个数字
        while (n < d) {
            for (int num : arr) {
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            for (int i = 0; i < len; i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if (order[i] != 0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;//将桶里计数器置0，用于下一次位排序
            }
            n *= 10;
            k = 0;//将k置0，用于下一轮保存位排序结果
        }
    }
}
