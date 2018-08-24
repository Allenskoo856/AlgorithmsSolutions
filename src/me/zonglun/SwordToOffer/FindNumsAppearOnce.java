package me.zonglun.SwordToOffer;

import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author : Administrator
 * @subject : 一个整形数组里面除了两个数字之外，其他数字都出现了两次
 *          要求找出这两个只出现一次的数字，并且时间复杂度为O（n）空间复杂度为O（1）
 * @create 2018-04-22 15:39
 */
public class FindNumsAppearOnce {


    /**
     * 本题的核心是使用异或运算，异或运算的核心是：不同取1，相同取0
     * 0 ^ 1 = 1 or 1 ^ 0 = 1
     * 0 ^ 0 = 0
     * 1 ^ 1 = 0
     * 对于两个相同的数字，异或得到的结果为0，两个不同的数字异或得到的结果不为0
     *
     *  Step1. 对数组中的每个元素异或运算，得到一个结果，记为num
     * Step2. 计算出 num的二进制中的，第一个1出现的位置（自右向左），记为position
     * Step3. 根据position位置上是否为1，将数组分为两个部分[2,2,3,3,6] 和 [4,5,5]
     * Step4. 分别对两个部分进行异或运算，得到两个结果就是只出现一次的数字
     *
     * @param array
     * @param num1
     * @param num2
     */
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length < 4) {
            return;
        }
        // step1. 每个元素异或运算
        int num = findNumAppearOnce(array);
        // step2. 获取num的二进制中的第一个1出现的位置（自右向左）
        int position = getPositionOf1(num);
        // step3. 根据position位置上是否为1，将数组分为两个部分
        int[] arr1 = new int[array.length];
        int[] arr2 = new int[array.length];
        partitionBy1(array, position, arr1, arr2);

        // step4. 分别对两个部分进行异或运算
        num1[0] = findNumAppearOnce(arr1);
        num2[0] = findNumAppearOnce(arr2);
    }

    /**
     * 根据position位置上是否为1，将数组分为两个部分
     * @param array
     * @param position
     * @param arr1
     * @param arr2
     */
    private void partitionBy1(int[] array, int position, int[] arr1, int[] arr2) {
        int p = 0, q = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i] & position) < position) {
                arr1[p++] = array[i];
            }else {
                arr2[q++] = array[i];
            }
        }
    }

    /**
     *  获取数字二进制中的第一个1出现的位置（自右向左）
     * @param num
     * @return
     */
    private int getPositionOf1(int num) {
        int position = 1;
        while(position <= num) {
            if((num & position) != 0) {
                break;
            }
            position = position << 1;
        }
        return position;
    }

    /**
     * 数组中的每个数都连续的或异运算
     * @param array
     * @return
     */
    private int findNumAppearOnce(int[] array) {
        int num = array[0];
        for(int i = 1; i < array.length; i++) {
            num = num ^ array[i];
        }
        return num;
    }


}
