package me.zonglun.AutumnRecruitment.FireHome.coding2019;

import java.util.Scanner;

/**
 * 交友大会
 *
 * @author : Administrator
 * @create 2018-09-17 21:39
 * @subject :
 *
 *
 */
public class makeFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                int k = sc.nextInt();
                System.out.println(getN(m,k));
            }
        }
    }

    private static int getN(int n, int m) {
        if (1 == n || 1 == m) {
            return 1;
        }
        if (n <= m) {
            return getN(n, n - 1) + 1;

        } else {
            return getN(n, m - 1) + getN(n - m, m);
        }
    }
}
