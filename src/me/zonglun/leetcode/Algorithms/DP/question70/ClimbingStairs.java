package me.zonglun.leetcode.Algorithms.DP.question70;

/**
 * 爬楼梯
 *
 * @author : Administrator
 * @create 2018-09-12 15:48
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
