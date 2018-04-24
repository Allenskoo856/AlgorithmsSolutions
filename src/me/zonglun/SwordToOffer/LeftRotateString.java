package me.zonglun.SwordToOffer;

/**
 * 左旋字符串的操作
 *
 * @author : Administrator
 * @Subject:  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部，
 *          定义一个函数实现字符串左旋转操作的功能。比如输入字符串“abcdefg"和数字2，
 *          该函数将返回左旋转2位得到的操作”cdefgab"
 * @create 2018-04-24 11:19
 */
public class LeftRotateString {

    public String leftRotateString(String str,int n) {
        if (n > str.length()) {
            return "";
        }
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, str.length());
        return s2 + s1;
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().leftRotateString("abcdefg", 2));
    }
}
