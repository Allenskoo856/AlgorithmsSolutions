package me.zonglun.AutumnRecruitment.FireHome.coding2019;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : Administrator
 * @create 2018-09-17 21:41
 * @subject :
 *  给出两个字符串a1a2a3...an和b1b2b3...bm，
 *  如果存在一种映射ai=f(bi)，且如果ai≠bi，f(ai)≠f(bi)，我们称这两个字符串同构。
 *
 *  输入
 *      输入第一行包含一个t，表示数据组数，t<=20.
 *
 *          对于每组数据，输入包含两行，每一行有一个字符串。
 *  *          每个字符串的长度不超过10000，字符串全部由小写字母组成。
 *  *  输出
 *
 *      对于每组数据输出一行，如果字符串同构，输出“Yes”,不同构则输出“No”。
 *
样例输入
        2
        abac
        bcbd
        aba
        abc
    样例输出
    Yes
    No
 *
 */
public class samleString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                String s1 = sc.nextLine();
                String s2 = sc.nextLine();
                HashMap<Character, Character> map = new HashMap<>();
                for (int i = 0; i < s1.length(); i++) {
                    char a = s1.charAt(i);
                    char b = s2.charAt(i);
                    if (map.containsKey(a)) {
                        if (map.get(a).equals(b)) {
                            continue;
                        } else {
                            System.out.println("No");
                        }
                    } else {
                        if (!map.containsValue(b)) {
                            map.put(a, b);
                        } else {
                            System.out.println("No");
                        }
                    }
                }
                System.out.println("Yes");
            }
        }
    }
}

