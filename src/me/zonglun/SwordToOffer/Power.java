/*
 * Copyright (C), 2015-2017
 * FileName: Power
 * Author:   Administrator
 * Date:     2017/11/22 0022 15:37
 * Description: 数值的整数次方    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈数值的整数次方〉
 *@subject      给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @Strategies
 *
 * @author Administrator
 * @create 2017/11/22 0022
 * @since 1.0.0
 */
public class Power {


    private boolean invalidInput = false;
    /**
     *  1.当底数为0且指数<0时
     *      会出现对0求倒数的情况，需进行错误处理，设置一个全局变量；
     *  2.判断底数是否等于0
     *  由于base为double型，不能直接用==判断
     *
     */
    private double pow(double base, int n) {
        // 当底数为0且指数<0时 , 输入不合法
        if (equal(base , 0.0) && n < 0) {
            invalidInput = true;
            return 0.0;
        }
        double result = 1.0;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= base;
        }
        if (n < 0)
            result = 1 / result;
        return result;
    }

    private boolean equal(double num1, double num2) {
        return num1 - num2 > -0.00001 && num1 - num2 < 0.00001;
    }

    public static void main(String[] args) {
        System.out.println(new Power().pow(3.4, 5));
    }
}
