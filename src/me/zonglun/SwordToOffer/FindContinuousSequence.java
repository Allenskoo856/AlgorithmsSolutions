package me.zonglun.SwordToOffer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author : Administrator
 * @subject :  输入一个递增的排序的数组和一个数字s，在数组中查找两个数，使得他们的和恰好是
 * s， 如果有多个则输出所有的对数
 * @create 2018-04-22 21:03
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = 3;
        while (small < middle) {
            // 初始化条件比需要的要小，需要加大big
            while (curSum < sum) {
                big++;
                curSum += big;
            }
            // 找到了相对应的数组串使得其相等
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big ; i++) {
                    list.add(i);
                }
                result.add(list);
            }
            // 剩余情况是结果curSum > result，此时增加small
            curSum -= small;
            small++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().findContinuousSequence(45));
    }

}
