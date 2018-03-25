package me.zonglun.SwordToOffer;

/**
 * 整数中1出现的个数
 *
 * @author : Administrator
 * @subject :   输入一个整数，求从1 到 N 中，这n个正整数的十进制中表示 1 出现的次数
 *          例如输入 12， 从1 到12 之中这些整数包含了1 的数字有 1，10，11（两个1），12 所以总共是5次
 * @create 2018-03-24 21:07
 */
public class NumberOf1Between1AndN_Solution {


    /**
     * 方法1：逐渐逐一考察 1~n 的每一个数里有多少个1，用数 % 10 来判断是否此为数字上有1 的个数，用num
     * 每次循环之后会/10 ，退到下一子位。分别从千-百-十等位数来考察
     * @param n
     * @return
     */
    public static int NumberOf_solutions(int n) {
        if (n < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getSingleNumbOf1(i);
        }
        return count;
    }

    private static int getSingleNumbOf1(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                res++;
            }
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf_solutions(12));
    }
}
