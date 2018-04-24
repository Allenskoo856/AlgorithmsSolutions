package me.zonglun.SwordToOffer;

/**
 * 将0,1,..,n-1这n个数拍成一个圆圈，从数字0开始每次从这个园区里删除第m个数字。求出这个圆圈中剩下的最后一个数字
 *
 * @author : Administrator
 * @Subject:    将0,1,..,n-1这n个数拍成一个圆圈，从数字0开始每次从这个园区里删除第m个数字。
 *              求出这个圆圈中剩下的最后一个数字
 * @create 2018-04-24 16:39
 */
public class LastRemaining_Solution {

    /**
     * 约瑟夫环的问题（Josephuse)环的问题
     * @param n 总共为n个数字
     * @param m 每次删除第m个数字
     * @return
     */
    public int lastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {
            i++;
            if (i >= n)
                i = 0;
            if (array[i] == -1)
                continue;
            step++;
            if (step == m) {
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining_Solution().lastRemaining_Solution(33,3));
    }
}
