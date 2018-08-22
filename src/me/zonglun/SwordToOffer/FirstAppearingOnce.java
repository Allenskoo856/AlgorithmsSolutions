package me.zonglun.SwordToOffer;

/**
 * @author : Administrator
 * @Subject: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符
 * @create 2018-05-12 19:36
 */
public class FirstAppearingOnce {
    private int[] hashTable = new int[256];
    private StringBuffer s = new StringBuffer();

    public void setS(StringBuffer s) {
        this.s = s;
    }

    // Insert one char from StringStream
    public void Insert(char ch) {
        s.append(ch);
        if (hashTable[ch] == 0) {
            hashTable[ch] = 1;
        } else {
            hashTable[ch] += 1;
        }
    }

    // return the first appearence once char in current stringstream
    public char FristAppearingOnce() {
        char[] str = s.toString().toCharArray();
        for (char c : str) {
            if (hashTable[c] == 1) {
                return c;
            }
        }
        return '#';
    }

}
