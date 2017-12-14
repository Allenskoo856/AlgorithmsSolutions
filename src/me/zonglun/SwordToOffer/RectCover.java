/*
 * Copyright (C), 2015-2017
 * FileName: RectCover
 * Author:   Administrator
 * Date:     2017/11/21 0021 21:44
 * Description: 矩形覆盖    
 */

package me.zonglun.SwordToOffer;

import org.jetbrains.annotations.Contract;

/**
 * 〈一句话功能简述〉<br>
 * 〈矩形覆盖〉
 * @subject  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *          请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Strategies
 *          其实就是一个斐波那契数列，满足公式：d(n) = d(n-1) + d(n-2)
 * @author Administrator
 * @create 2017/11/21 0021
 * @since 1.0.0
 */
public class RectCover {
    private static int Num(int target) {
        if (target < 1)
            return 0;
        else if (target <= 2)
            return target;
        else
            return Num(target -1) + Num(target - 2);
    }

    @Contract(pure = true)
    private static int NUm1(int target) {
        int tempNum = 1;
        int result = 2;
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int count = 2;
        while (count < target) {
            result += tempNum;
            tempNum = result - tempNum;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(RectCover.Num(5));
    }
}
