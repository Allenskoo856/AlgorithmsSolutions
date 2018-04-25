package me.zonglun.SwordToOffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author : Administrator
 * @subject : 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @create 2018-04-24 22:17
 */
public class AddFunction {


    /**
     * 十进制操作：5 + 7 = 12，三步走
     * 第一步：相加各位的值，不算进位，得到2
     *
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new AddFunction().add(4,6));
    }
}
