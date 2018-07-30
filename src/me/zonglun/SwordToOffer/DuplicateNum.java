package me.zonglun.SwordToOffer;

import java.util.HashSet;

/**
 * 数组中重复的数字
 *
 * @author : Administrator
 * @subject : 在一个长度为n的数组里面，所有的数字都在0 到 n - 1 的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 *      请找出数组中任意一个重复的数字，其输出为第一个重复的数字2
 * @create 2018-04-25 21:23
 */
public class DuplicateNum {

    /**
     *
     * @param numbers 整数数组，长度为n
     * @param length   长度、
     * @param duplication  重复的数字
     * @return boolean
     */
    public boolean deplicateNum(int numbers[], int length, int[] duplication) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!hs.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

}
