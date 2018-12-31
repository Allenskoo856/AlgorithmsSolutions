package me.zonglun.leetcode.utils;

/**
 * @author : Administrator
 * @create 2018-11-20 16:29
 */
public class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
