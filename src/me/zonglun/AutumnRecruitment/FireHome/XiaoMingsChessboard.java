package me.zonglun.AutumnRecruitment.FireHome;

import java.util.Scanner;

/**
 * 小明的棋盘
 *
 * @author : Administrator
 * @create 2018-09-08 20:23
 * @subject :
 *
 *      题目描述
 *
 * 小明有天看到一个放满黑子和白子交替的大小为n*m的棋盘。然而小明只喜欢只有一种颜色的棋盘，即只有黑子或者白子。小明拥有超能力可以将一个里面的矩阵的棋子的颜色反转,但是他一天最多只能使用c次超能力。如果可以将所有棋子变成一种颜色，小明就会买这个棋盘，请问小明是否会买这个棋盘。
 *
 *      输入
 * 第一行一个整数 T(T≤10) 表示数据组数。
 *
 * 每组数据有一行, 三个正整数 n,m,c(1≤n,m,c≤1e9)。
 *
 *
 *
 * 样例输入
 * 2
 *
 * 1 2 1
 *
 * 2 2 1
 *
 * 输出
 * 如果小明买这个棋盘输出 "Yes" 否则输出 "No".
 *
 *
 *
 * 样例输出
 *
 * Yes
 * No
 *
 */
public class XiaoMingsChessboard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int t = scan.nextInt();
            for (int i = 0; i < t; i++) {
                long n = scan.nextInt();
                long m = scan.nextInt();
                long c = scan.nextInt();
                if (n /2 + m / 2 <= c) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
