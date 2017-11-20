/*
 * Copyright (C), 2015-2017
 * FileName: Fibonacci
 * Author:   Administrator
 * Date:     2017/11/19 0019 22:15
 * Description: 斐波那契数列    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈斐波那契数列〉
 *@subject  大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
                n<=39,,       0  -----  n=0
        斐波那契数列   f(n) =  1  ----- n = 1
 *                           f(n-1)+f(n-2)  --- n>=2
 * @Strategies 不建议使用递归的方法，时间的复杂度更高
 * @author Administrator
 * @create 2017/11/19 0019
 * @since 1.0.0
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        int numFn1 = 0, numFn2 = 1, currentNum = 0;
        for (int i = 2; i <= n ; i++) {
            currentNum = numFn1 + numFn2;
            numFn1 = numFn2;
            numFn2 = currentNum;
        }
        return currentNum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fibonacci(30));
    }
}
