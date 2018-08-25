package me.zonglun.SwordToOffer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 *
 * @author : Administrator
 * @subject 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * @expmle 例如，如果输入如下矩阵： 1  2  3      4
 *                              5  6   7     8
 *                              9  10  11   12
 *                              13 14 15    16
 *          则依次打印出数字 1,2,3,4, 8,12,16,15,14, 13,9,5,6 ,7,11, 10.
 * @create 2018-03-15 22:01
 */
public class PrintMatrix {

    /**
     * @param matrix
     * @return ArrayList
     */
    private ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0; // start代表层数

        // 对于一个6 * 6的矩阵而言，最后一圈需要打印四个数字
        // 它的左上角坐标是(2,2)，满足6 > 2 * 2
        while(2 * start < rows && 2 * start < cols) { // 不能写成 rows/2 的形式
            int endX = cols - start - 1;
            int endY = rows - start - 1;
            // 第一行是肯定要打印的
            for(int i = start; i <= endX; i++) {
                list.add(matrix[start][i]);
            }
            // 第二步的条件是终止行号大于起始行号
            if(start < endY) {
                for(int i = start + 1; i <= endY; i++) {
                    list.add(matrix[i][endX]);
                }
            }
            // 第三步的条件是至少两行两列，终止行号大于起始行号 并且终止列号大于起始列号
            if(start < endX && start < endY) {
                for(int i = endX - 1; i >= start; i--) {
                    list.add(matrix[endY][i]);
                }
            }
            // 第四步的条件是至少有三行两列，终止行号至少比起始行号大2，终止列号大于起始列号
            if(start < endX && start < endY - 1) {
                for(int i = endY - 1; i >= start + 1; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++; // 一层一层向里打印
        }
        return list;
    }

}
