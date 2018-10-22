package me.zonglun.AutumnRecruitment.Yongyou;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 连续数组
 *
 * @author : Administrator
 * @create 2018-09-10 15:43
 * @subject :
 *      求一个数列中最大连续数字个数及起始数字，数列元素为整数，有序且不重复，部分数字连续。
 *      例如：{1, 3, 4, 6, 7, 8, 9, 11}的最大连续个数为4，起始数字为6。
 *
 *      输入
 * 在一行中完成输入，多个数字之间以空格间隔。
 *
 * 输出
 * 输出最大连接数字的个数和起始数字，格式为：[起始数字, 连续个数]
 *
 * 样例输入
 * 1 4 5 6 7 8 10 11 12 14 18
 *
 * 样例输出
 * [4, 5]
 */
public class reactingArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] dirs = strs.split("\\s");
        int[] arrays = new int[dirs.length];
        for (int i = 0; i < dirs.length; i++) {
            arrays[i] = Integer.valueOf(dirs[i]);
        }
        int cur = 0, next = 1;
        int sum = 0, temp = 0;

        Map<Integer, Integer> maps = new HashMap<>();
        while (cur < arrays.length && next < arrays.length) {
            if (arrays[cur] + 1 == arrays[next]) {
                temp++;
            }
            if (arrays[cur] + 1 != arrays[next]) {
                maps.put(temp, cur);
                temp = 0;
            }
            if (sum < temp) {
                sum = temp;
            }
            cur++;
            next = cur + 1;
        }
        int ress = arrays[maps.get(sum) - sum];
        System.out.printf("[%d, %d]", ress, sum + 1);
    }
}
