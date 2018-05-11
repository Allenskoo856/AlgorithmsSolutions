package me.zonglun.SwordToOffer;

/**
 * 乘积数组
 *
 * @author : Administrator
 * @Subject: 给定一个数组A【0，1，。。。。，n - 1】，请构建一个数组B【0，1，。。。，n - 1】
 *  其中B的元素B[i] = A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 *   不允许使用除法
 * @example:
 *      B0    1    A1     A2 ---   A（n-2） A（n -1）
 *      B1    A0   1      A2 ---   A（n-2） A（n -1）
 *      B2    A0   A1     1 -----  A（n-2） A（n -1）
 *      ___   A0   A1   ----   1   A（n-2） A（n -1）
 *    B(n-2)  A0   A1   ----  A（n-3）  1   A（n -1）
 *    B(n-1)  A0   A1   ----  A（n-3） A（n-2）   1
 * @create 2018-05-11 10:23
 */
public class MultiplyArray {

    /**
     * B[i] 的值可以看作矩阵中每行的乘积数目
     * @param A
     * @return
     */
    public int[] mutiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            // 首先计算，下三角形的连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            // 再来计算上三角形
            for (int j = length - 2; j >= 0 ; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
