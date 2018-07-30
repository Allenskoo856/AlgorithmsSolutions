package me.zonglun.SwordToOffer;

/*
* @subejct: 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
* @example: 例如输入 “abaccdeff" 则输出”b“
* */
public class FirstNotRepeatingChar {

    public int solution(String str) {
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
