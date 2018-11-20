package me.zonglun.leetcode.Algorithms.DP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 0-1背包问题
 *
 * @author : Administrator
 * @create 2018-09-13 16:21
 * @subject :
 *
 *      现有n件物品和一个容量为c的背包。第i件物品的重量是重量为w[i]，价值是v[i]。
 *      已知对于一件物品必须选择取（用1表示）或者不取（用0表示），且每件物品只能被取一次（这就是“0-1”的含义）。
 *      求放置哪些物品进背包，可使这些物品的重量总和不超过背包容量，且价值总和最大。
 * @Strategies :
 *
 * 假设有5件物品，其重量分别是w={2，2，6，5，4}，价值分别是v={6，3，5，4，6}，背包容量为10。在数学问题中这是典型的线性规划问题，我们可以在线性约束范围内求解目标表达式。但是怎么用计算机语言实现呢？我们可以先这样考虑，当背包容量为1时，如何放置物品才能使背包中价值最大；同样当背包容量为2时，如何放置能使背包中价值最大，以此类推，直到背包容量为10。此时我们需要维护一张二维表m[i][j]，其中横坐标i表示物品，纵坐标表示背包容量（1<=j<=10）。
 *
 *
 * m[i][j]表示当可以放入前i件物品且背包容量为j时的最大价值。当只能放入第一件物品即i=0时：若背包容量j<w[0]，物品不能够被放入背包；若j>=w[0]时，物品可以放入背包，此时m[0][j]=v[0]。当可以放入前2件物品即i=1时，我们需要进行这样的处理：若j<w[1]时，说明第2件物品不能被放入背包内，此时背包的最大价值为背包中只放入第一件物品的最大价值，即m[1][j]=m[0][j]；若j>=w[1]时，假设此时背包容量j=8，第二件物品可以被放入背包内，那么便会出现两种情况：
 *
 *  x - ( p + q ) + ( y - a )
 */
public class Packages01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        char[] ss = expr.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        int i = 0, j = 1;
        for (char ca : ss) {
            list.add(ca);
        }
        while (i < ss.length && j < ss.length) {
            if (ss[i] == '-' && ss[j] == '(' && ss[j +2] == '+' && j +2 < ss.length) {
                list.set(j + 2, '-');
            }
            if (ss[i] == '-' && ss[j] == '(' && ss[j +2] == '-' && j +2 < ss.length) {
                list.set(j +2, '+');
            }
            if (ss[j] == '(' || ss[j] == ')') {
                list.remove(0);
            }
            i++;
            j = i + 1;
        }
        for (char s : list) {
            System.out.print(s);
        }
    }
}
