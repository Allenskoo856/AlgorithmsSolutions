package me.zonglun.leetcode;

import java.util.Random;

/**
 * @author : Administrator
 * @create 2018-11-20 20:58
 */
public class RundomNumArray {

    private static Random rand = new Random(47);

    //生成一个[i,j]之间的随机数
    public static int randInt(int i, int j){
        return rand.nextInt(j-i+1) + i;
    }

    public static int[] algorithm1(int N) {
        int []a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            while (true) {
                a[i] = randInt(1, N); //生成[1,N]之间的一个随机数
                for (int j = 0; j < i; ++j) {
                    if (a[i] == a[j]) {
                        break;//如果这个随机数已经在前面出现过了,break,下一轮继续生成另一个随机数,直至a[i]与前面所有的数不同
                    }
                } //end for


                break;//本次生成的a[i]在前面没有出现过, break while, i++,下一轮生成a[i+1]
            }//end while
        }
        return a;
    }


    public static int[] algorithm3(int N){
        int[] a = new int[N];
        for(int i = 1; i <= N; i++)
            a[i-1] = i;
        for(int i = 1; i < N; i++)
            swapReference(a, i, randInt(0, i));
        return a;
    }

    //生成一个即有正数又有负数的随机数组
    public static int[] randomArr(int N){
        int [] a = new int[N];
        for(int i = 1; i <= N/2; i++)
            a[i-1] = i;
        for(int j = N; j > N/2; j--)
            a[j-1] = -j;
        for(int i = 1; i < N; i++)
            swapReference(a, i, randInt(0, i));
        return a;
    }

    private static void swapReference(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        long start3 = System.currentTimeMillis();
        algorithm3(100000);
        System.out.println(System.currentTimeMillis() - start3);

        long start = System.currentTimeMillis();
        algorithm1(100000);
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }
}
