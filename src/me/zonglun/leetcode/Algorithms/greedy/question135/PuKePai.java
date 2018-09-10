package me.zonglun.leetcode.Algorithms.greedy.question135;

/**
 * 扑克牌
 *
 * @author : Administrator
 * @create 2018-09-09 22:27
 */
public class PuKePai {
    public static void main(String[] args) {
        int[] RMB = {100, 50, 20, 10, 5, 2, 1};
        int num = 7;
        int X = 628;
        int count = 0;
        for (int i = 0; i < num; i++) {
            int use = X / RMB[i];
            count += use;
            X -= RMB[i] * use;
            System.out.printf("需要面额为 %d的 %d张\n",RMB[i],use);
            System.out.printf("剩余需要支付的RMB %d\n", X);
        }
        System.out.printf("总共需要%d个数字",count);
    }
}
