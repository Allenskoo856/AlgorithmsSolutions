package me.zonglun.SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 字符串的排序
 *
 * @author : Administrator
 * @subject :   输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *              例如输入字符串 abc,则打印出由字符 a, b ,c 所能排列出来的所有字符串 abc, acb , bac , bca, cab 和 cba。
 * @required:   输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @create 2018-03-19 18:18
 */
public class PermutationList {

    /**
     *
     * @param str
     * @return  ArrayList<String>
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    /**
     *
     * @param chars
     * @param i
     * @param list
     */
    private static void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        // 如果给定的i的值是恰好是最大长度，则添加到集合中，注意强转
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }


    /**
     * 辅助交换函数
     * @param chars
     * @param i   i 索引
     * @param j   j 索引
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abb";
        String str2 = "abcd";
        String str3 = "abca";
        String str4 = "aba";
        String str5 = "";
        System.out.println(Permutation(str));
        System.out.println(Permutation(str2));
        System.out.println(Permutation(str3));
        System.out.println(Permutation(str4));
        System.out.println(Permutation(str5));
    }
}
