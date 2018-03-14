package me.zonglun.test;

import java.util.Scanner;

public class Main {

    private static int solutions(int[][] arr) {
        if (arr[0].length != 2 || arr[0][1] != arr.length -1) {
            return -1;
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length != 3 || arr[i][0] > arr[0][0] || arr[i][1] > arr[0][0]) {
                return -1;
            }
            while (arr[i][2] > result) {
                result = arr[i][2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            System.out.print(n);
        }
    }
}
