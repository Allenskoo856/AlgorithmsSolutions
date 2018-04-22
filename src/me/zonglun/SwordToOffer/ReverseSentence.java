package me.zonglun.SwordToOffer;

/**
 * 输入英文反转句子中的单词的顺序，但是单词的字符的顺序保持不变
 *
 * @author : Administrator
 * @subject : 输入英文反转句子中的单词的顺序，但是单词的字符的顺序保持不变,输入“ I am a student."
 *          则输出”student. a am I“
 * @create 2018-04-22 22:11
 */
public class ReverseSentence {

    /**
     * 1. 第一步反转句子中的所有的字符，变为”.tneduts a ma I"
     * 2. 第二步翻转单个单词内部的字符的顺序，可以得到“student. a am I"
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        char[] chars = str.toCharArray();
        // 第一步
        revers(chars,0,chars.length - 1);
        int blank = -1;
        // 根据空格分隔每个单词，单词内部单独反转
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                revers(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        //  反转最后一个单词
        revers(chars,blank + 1, chars.length - 1);
        return new String(chars);
    }

    /**
     * 直接反转单个字符串
     * @param chars
     * @param low
     * @param high
     */
    private void revers(char[] chars,int low,int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().reverseSentence("I am a student."));
    }
}
