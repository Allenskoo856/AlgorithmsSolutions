package me.zonglun.AutumnRecruitment.Yongyou;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * 级次编码
 *
 * @author : Administrator
 * @create 2018-09-10 15:33
 * @subject :
 *      系统采用级次编码描述树结构数据，如一级部门编码为AA，则二级部门编码为AA01、AA02等，即每个级次使用固定的编码长度，子级对象的编码以父级对象编码起始。请基于以下条件实现功能：
 *
 * 1、 一级编码长度为2，二级为4，三级为6，依次递增;
 *
 * 2、 对输入的一组无序编码进行排列（按字符正序），以树形列表形式输出；
 *
 * 忽略长度非法或无法匹配到父级的数据。
 *
 * 输入
 * 在一行中完成输入，多个编码之间以空格间隔。
 *
 * 输出
 * 每个编码输出一行，子级节点需要增加制表符，每增加一级多输出一个制表符。
 *
 * 样例输入
 * 01 0101 0301 03 030101 0201 02 0303 0401 033
 *
 * 样例输出
 * 01
 * 	    0101
 * 02
 * 	    0201
 * 03
 * 	    0301
 * 		    030101
 * 	    0303
 */
public class dicCoding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String[] dirs = strs.split("\\s");

        Arrays.sort(dirs);
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].length() == 2 )
                System.out.println(dirs[i]);
            if (dirs[i].length() == 4) {
                System.out.println("\t" + dirs[i]);
            }
            if (dirs[i].length() == 6) {
                System.out.println("\t\t" + dirs[i]);
            }
        }
    }
}
