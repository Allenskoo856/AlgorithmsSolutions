package me.zonglun.leetcode;

/**
 * @author : Administrator
 * @create 2018-11-20 19:28
 */

import me.zonglun.leetcode.utils.StopWatch;

/**
 * 最大子序列和的问题求解
 */
public class MinStringSum {

    /*
     * Cubie maxunum subsequence sum algorithm
     *
     * 任何负的 子序列都不可能是最大子序列和 的前缀
     * 当加上 下标 j 所在的元素 使得 当前序列的和变成负数时，根据①，可以从 j+1 处重新开始计算下一段子序列的和。
     */
    public static int maxSubSum1(int[] a) {
        int maxSum = 0, thisSum = 0;
        for (int anA : a) {
            thisSum += anA;
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = RundomNumArray.randomArr(1000* 70);
        StopWatch stopWatch = new StopWatch();
        int result = MinStringSum.maxSubSum1(a);
        double timer = stopWatch.elapsedTime();
        System.out.println("result is : " + result + " spend timers=: " + timer + " seconds");
    }
}
