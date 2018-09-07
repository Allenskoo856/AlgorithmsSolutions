package me.zonglun.leetcode.arrayAndString.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author : Administrator
 * @create 2018-09-07 11:39
 * @subject ：
 *      给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 *      你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *      示例:
 *
 *      给定 nums = [2, 7, 11, 15], target = 9
 *
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("NO two sum");
    }
}
