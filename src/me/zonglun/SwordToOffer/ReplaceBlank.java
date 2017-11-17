/*
 * Copyright (C), 2015-2017
 * FileName: ReplaceSpace
 * Author:   Administrator
 * Date:     2017/11/17 0017 19:32
 * Description: 替换空格    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈替换空格〉
 *@subject  请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy
 *                  .则经过替换之后的字符串为We%20Are%20Happy。
 *@Strategies   1. 使用replaceAll 的API 直接调用正则表达式来求解，但是显然不应该是算法题目要求使用的
 *              2. 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下复杂度为o（n2）
            使用从后往前替换，先计算替换后的空间，使用两个指针， indexOld 为为替换前的索引，indexNew为替换后索引
                两者都指向队列的后一位
            然后从后往前移动，则每个字符只为移动一次，这样效率为o(n)更高一点
 * @author Administrator
 * @create 2017/11/17 0017
 * @since 1.0.0
 */
public class ReplaceBlank {

    private static String replaceBlank(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                spaceNum++;

        int indexOld = str.length() -1;
        int indexNew = indexOld + spaceNum * 2;
        int newLength = indexNew + 1;
        str.setLength(newLength);   // 设置新数组的长度
        // 拷贝数组并替换的过程
        while (indexOld >= 0 && indexNew > indexOld) {
            if (str.charAt(indexOld) == ' '){
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--,'2');
                str.setCharAt(indexNew--,'%');
            }else {
                str.setCharAt(indexNew--,str.charAt(indexOld));
            }
            --indexOld;
        }
        return str.toString();
    }

    /*调用 API
    * */
    private static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s","%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are Happy to meet you");
        System.out.println(ReplaceBlank.replaceSpace(str));
        System.out.println(ReplaceBlank.replaceBlank(str));
    }
}
