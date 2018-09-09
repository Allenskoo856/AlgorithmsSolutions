package me.zonglun.AutumnRecruitment.FireHome;

import java.util.Scanner;

/**
 * 学打字
 *
 * @author : Administrator
 * @create 2018-09-08 21:07
 * @subject :
 * 小明同学刚刚学习打字，现在老师叫他输入一个英文字符串。小明发现，这个英文字符串只由大写和小写的英文字母构成。小明同学只会使用Caps Lock键来切换大小写输入。
 * <p>
 * 最开始，大写锁定处于关闭状态，小明的电脑只能输入小写英文字母。当大写锁定关闭时，按一下Caps Lock键可以打开大写锁定，之后只能输入大写字母；当大写锁定打开时，按一下Caps Lock键可以关闭大写锁定，之后只能输入小写字母。
 * <p>
 * 现在小明想知道输入这个字符串最少需要按键多少次。
 * <p>
 * 输入
 * 输入只有一行，一个字符串，字符串中只有大写字母和小写字母，字符串长度不超过100000。
 * 样例输入
 * aAAbB
 * 输出
 * 输出一行，最少的按键次数。
 * 案例输出为8
 */
public class learningSpelling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int sumNum = 0;
        if (Character.isUpperCase(chars[0])) {
            sumNum = 1;
        } else {
            sumNum = 0;
        }
        for (int i = 0; i < chars.length -1; i++) {
            int j = i + 1;
            char c = chars[i], d = chars[j];
            if (Character.isUpperCase(c) ^ Character.isUpperCase(d)) {
                sumNum ++;
            }
        }
        System.out.println(sumNum + chars.length);
    }
}
