package me.zonglun.leetcode.Algorithms.greedy;

import java.util.Scanner;

/**
 * @author : Administrator
 * @create 2018-09-10 14:28
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double n = sc.nextInt();
            int m = sc.nextInt();
            double sum = 0;
            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f",sum);
            System.out.println();
        }
    }
}
