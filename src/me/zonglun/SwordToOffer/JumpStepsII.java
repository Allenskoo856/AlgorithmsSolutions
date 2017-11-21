/*
 * Copyright (C), 2015-2017
 * FileName: JumpStepsII
 * Author:   Administrator
 * Date:     2017/11/20 0020 22:02
 * Description: 跳台阶2    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈跳台阶2〉
 *@subject  一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级……它也可以跳上 n 级台阶。
 *          求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 * @Strategies
                因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
                跳1级，剩下n-1级，则剩下跳法是f(n-1)
                跳2级，剩下n-2级，则剩下跳法是f(n-2)
                所以f(n)=f(n-1)+f(n-2)+...+f(1)
                因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
                所以      f(n) =  1       (n = 1)
                                2*f(n-1)  (n >= 2)
 * @author Administrator
 * @create 2017/11/20 0020
 * @since 1.0.0
 */
public class JumpStepsII {
    private static int jump(int target) {
        if (target <= 0)
            return -1;
        else if (target == 1)
            return 1;
        else
            return 2 * jump(target - 1);
    }

    private static int jump2(int target) {
        if (target <= 0)
            return -1;
        else
            return 1 << (target - 1);   // 位移运算 等效为 (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpStepsII.jump(4));
        System.out.println(JumpStepsII.jump2(8));
    }
}
