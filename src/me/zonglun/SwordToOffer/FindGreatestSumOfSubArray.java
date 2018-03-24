package me.zonglun.SwordToOffer;

/**
 * 连续子数组的最大的和
 *
 * @author : Administrator
 * @subject : 输入一个整型数组，数组里面既有正数，也有负数，数组中一个或者连续的多个整数组成一个子数组，求所有的子数组的最大值？
 *              并且要求时间的复杂度为o（n）
 *             例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *             在如{1, -2, 3, 10, -4, 7, 2, -5} 最大的子数组为{3, 10, -4, 7, 2},因此输出该子数组的和为18
 *            (子向量的长度至少是1)
 * @create 2018-03-24 20:12
 */
public class FindGreatestSumOfSubArray {

    /**
     * 返回整数值
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int curNum = 0;
        int countNum = array[1];
        for (int i = 0; i < array.length; i++) {
            if (curNum <= 0) {  // 如果当前子数组串累加之后，和为负数或者为零，则直接赋值给当前的元素
                curNum = array[i];
            } else {
                curNum += array[i];
            }
            if (curNum > countNum) {
                countNum = curNum;
            }
        }
        return countNum;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] array2 = {6,-3,-2,7,-15,1,2,2};
        int[] array3 = {-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray(array));
        System.out.println(FindGreatestSumOfSubArray(array2));
        System.out.println(FindGreatestSumOfSubArray(array3));
    }

}
