/*
 * Copyright (C), 2015-2017
 * FileName: FindInPartiallySortedMatrix
 * Author:   Administrator
 * Date:     2017/11/17 0017 10:33
 * Description: 二维数组的查找    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈二维数组的查找〉
 *@subject  在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *          请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数,
 *@example  1  2  8  9
 *          2  4  9  8          在这个数组中查找元素 7 则返回true；否则查找 5 返回false
 *          4  7  10 13
 *          6  8  11 15
 * @Strategies
 *       思路一：
                利用二维数组由上到下，由左到右递增的规律，
                那么选取右上角或者左下角的元素a[row][col]与target进行比较，
                当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
                即col--；
                当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
                即row++；
        思路二:
                把每一行看成有序递增的数组，
                利用二分查找，
                通过遍历每一行得到答案，
                时间复杂度是nlogn
 * @author Administrator
 * @create 2017/11/17 0017
 * @since 1.0.0
 */
public class FindInPartiallySortedMatrix {
        public static boolean find(int target, int[][] arr) {
                // 取右上角的点为基准点
                int col = 0;    // 列的开始点为0
                int row = arr[0].length - 1;    // 行的开始点为最大值
                while (col <= arr.length -1 && row >= 0){
                        if (target == arr[row][col])
                                return true;
                        else if (target < arr[row][col])
                                row--;
                        else
                                col++;
                }
                return false;
        }

        public static boolean find2(int target, int[][] arr){
                for (int[] anArr : arr) {
                        int l = 0;
                        int r = anArr.length - 1;
                        while (l < r) {
                                int mid = (l + r) / 2;
                                if (target > anArr[mid])
                                        l = mid + 1;
                                else if (target < anArr[mid])
                                        r = mid - 1;
                                else
                                        return true;
                        }
                }
                return false;
        }

        public static void main(String[] args) {
                int[][] arr = {{1,2,8,9},{2,4,9,8},{4,7,10,13},{6,8,11,15}};
                System.out.println(FindInPartiallySortedMatrix.find(5,arr));
                System.out.println(FindInPartiallySortedMatrix.find2(7,arr));
        }
}
