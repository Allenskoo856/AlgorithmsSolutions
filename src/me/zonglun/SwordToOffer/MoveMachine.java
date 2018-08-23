package me.zonglun.SwordToOffer;

import java.util.Scanner;

/**
 * 机器人运动的最大值
 *
 * @author : Administrator
 * @create 2018-08-23 11:36
 * @subject :
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MoveMachine {

    /**
     *
     * @param threshold 目标值
     * @param rows    行
     * @param cols    列
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visted = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visted[i][j] = false;
            }
        }
        int count = movingCore(threshold, rows, cols, 0, 0, visted);
        return count;
    }

    public int movingCore(int threshold, int rows, int cols, int row, int col, boolean[][] visted) {
        int count = 0;
        if (checkVisted(threshold, rows, cols, row, col, visted)) {
            visted[row][col] = true;
            count = 1 + movingCore(threshold, rows, cols, row - 1, col, visted)
                    + movingCore(threshold, rows, cols, row, col - 1, visted)
                    + movingCore(threshold, rows, cols, row + 1, col, visted)
                    + movingCore(threshold, rows, cols, row, col + 1, visted);
        }
        return count;
    }

    private boolean checkVisted(int threshold, int rows, int cols, int row, int col, boolean[][] visted ) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && (getDigitSum(row) + getDigitSum(col) <= threshold) && !visted[row][col]) {
            return true;
        }
        return false;
    }

    /**
     * 得到这个位数之和
     *
     * @param number 数字
     * @return  数字各个位数之和
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入限制条件k:");
        int k = sc.nextInt();
        System.out.println("请输入方格的行数m：");
        int m = sc.nextInt();
        System.out.println("请输入方格的列数n:");
        int n = sc.nextInt();
        MoveMachine mv = new MoveMachine();
        sc.close();
        System.out.println("矩阵能到达的方格数是：");
        System.out.println(mv.movingCount(k, m, n));
    }


}
