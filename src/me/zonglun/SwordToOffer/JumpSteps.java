/*
 * Copyright (C), 2015-2017
 * FileName: JumpSteps
 * Author:   Administrator
 * Date:     2017/11/20 0020 21:43
 * Description: 跳台阶    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈跳台阶 〉
 *@subject  一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *              求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @Strategies
            对于本题,前提只有 一次 1阶或者2阶的跳法。
            a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
            b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
            c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 
            d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
            e.可以发现最终得出的是一个斐波那契数列：
 * @author Administrator
 * @create 2017/11/20 0020
 * @since 1.0.0
 */
public class JumpSteps {
    private static int jumpFloor(int target) {
        if (target <= 2)
            return target;
        int numFn1 = 1, numFn2 = 2, currentNum = 0;
        for (int i = 3; i <= target ; i++) {
            currentNum = numFn1 + numFn2;
            numFn1 = numFn2;
            numFn2 = currentNum;
        }
        return currentNum;
    }

    public static void main(String[] args) {
        System.out.println(JumpSteps.jumpFloor(30));
    }
}
