package me.zonglun.leetcode.Algorithms;

import java.util.Scanner;

/**
 * 水仙花
 *
 * @author : Administrator
 * @create 2018-09-10 14:43
 */
public class shuixianhua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = n; i < m; i++) {
                int fristNum = i / 100;
                int secondNum = i / 10 % 10;
                int thirdNum = i % 10;
                if (fristNum * fristNum * fristNum + secondNum * secondNum * secondNum + thirdNum * thirdNum * thirdNum == i) {
                    System.out.println(i);
                }
            }
            System.out.println("no");
        }
    }
}
