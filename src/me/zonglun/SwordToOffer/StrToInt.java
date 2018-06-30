package me.zonglun.SwordToOffer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数
 *
 * @author : Administrator
 * @create 2018-04-25 18:53
 */
public class StrToInt {

    // 判断是否输入合法
    public static boolean isInvalid  = false;

    public int strToInt(String str) {
        if (str == null || str.equals("")) {
            isInvalid = true;
            return 0;
        }
        char[] arr = str.toCharArray();
        int symbol = 1;
        if (arr[0] == '-') {
            symbol = -1;
        }
        int result = 0;
        for (int i = (arr[0] == '-' || arr[0] == '+') ? 1 : 0; i < str.length(); i++) {
            if (!('0' <= arr[i] && arr[i] <= '9')) {
                isInvalid = true;
                return 0;
            }
            result = result * 10 + arr[i] - '0';
            if (symbol == 1 && result > Integer.MAX_VALUE) {
                isInvalid = true;
                return 0;
            }
        }
        return result * symbol;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt("-234"));
        System.out.println(new StrToInt().strToInt("-234A"));
        System.out.println(new StrToInt().strToInt("+2147483647"));
        System.out.println(new StrToInt().strToInt("1a33"));
    }
}
