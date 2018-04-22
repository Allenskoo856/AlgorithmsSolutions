package me.zonglun.SwordToOffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author : Administrator
 * @create 2018-04-22 21:45
 */
public class FindNumbersWithSum {

    /**
     * 设置一头一尾指针，两者和相加则为s则满足，若比s大，则尾部指针向前移动，
     * 所和比s小， 头部指针向后移动，当两者找到第一个和等于s的值，意味着此时输出的乘积最小
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int head = 0;
        int foot = array.length - 1;

        while (head < foot) {
            int curSum = array[head] + array[foot];
            if (curSum == sum) {
                list.add(array[head]);
                list.add(array[foot]);
                return list;
                // 若比s大，则尾部指针向前移动，
            } else if (curSum > sum) {
                foot--;
            } else {
                head++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 5, 3, 7};
        System.out.println(new FindNumbersWithSum().findNumbersWithSum(array,10));
    }
}
