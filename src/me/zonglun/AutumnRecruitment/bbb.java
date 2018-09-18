package me.zonglun.AutumnRecruitment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : Administrator
 * @create 2018-09-12 10:41
 */
public class bbb {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int i = -1, m = 0;
        boolean flag = true;
        while (flag) {
            i++;
            m++;
            if (m == 5) {
                arr.remove(i);
                m = 0;
                i--;
            }
            if (i == arr.size() - 1) {
                i = -1;
            }
            if (arr.size() == 1) {
                flag = false;
                System.out.println(arr.get(0));
            }
        }
    }
}
