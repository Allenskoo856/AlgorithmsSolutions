package me.zonglun.SwordToOffer;

/**
 * @author : Administrator
 * @Subject: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *              例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *              但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @create 2018-05-11 20:21
 */
public class StringIsNum {

    /**
     * 表述数值的字符串情况较多，分析如下：
     *
     *  首先，第一个字符可能是正’+’，负’-‘号，也可能是数字。
     *  如果遇到了’.’，说明是一个小数，那么’.’后面应该是一串0到9的数字
     *  如果遇到了’E’，说明是一个科学记数，那么’E’后面应该是一串0到9的数字，注意E后面可以接一个负号，如：-1E-16
     */
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1) {
            return false;
        }
        boolean flags = scanInteger(str);
        if (index < str.length && str[index] == '.') {
            index++;
            flags = scanUnInteger(str) || flags;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flags = flags && scanInteger(str);
        }
        return flags && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnInteger(str);
    }

    /**
     * 判断是否存在整数
     *
     * @param str
     * @return
     */
    private boolean scanUnInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        // 是否存在整数
        return start < index;
    }

}
