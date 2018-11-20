package me.zonglun.leetcode;

import me.zonglun.leetcode.utils.StopWatch;

/**
 * @author : Administrator
 * @create 2018-11-20 16:31
 */
public class FibooCiles {

    private int filbees(int n) {
        if (n < 3) {
            return 1;
        } else {
            return filbees(n - 1) + filbees(n - 2);
        }
    }

    private int fibees(int frist, int second, int n) {
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return frist + second;
        } else {
            return fibees(second, frist + second, n - 1);
        }
    }


    private int fibbAdls(int n) {
        int frist = 1;
        int second = 1;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = frist + second;
            frist = second;
            second = ret;
        }
        return second;
    }

    public static void main(String[] args) {
        /*StopWatch timer = new StopWatch();
        int s = (new FibooCiles().filbees(40));
        double time = timer.elapsedTime();
        System.out.println(s + " result " + " Spend time: " + time + " seconds");*/

        StopWatch timer1 = new StopWatch();
        int s1 = (new FibooCiles().fibbAdls(400000));
        double time1 = timer1.elapsedTime();
        System.out.println(s1 + " result " + " Spend time: " + time1 + " seconds");
    }
}
