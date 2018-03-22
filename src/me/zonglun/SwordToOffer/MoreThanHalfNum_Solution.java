package me.zonglun.SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的个数
 *
 * @author : Administrator
 * @subject : 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *          例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *          由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出 0。
 * @create 2018-03-19 21:23
 */
public class MoreThanHalfNum_Solution {

    /**
     * 方法1：使用hashMap来使用，具体的做法是遍历数组，将其放到集合之中，存在则count++
     * 然后遍历Map ，判断count的数量比数组的中间值还要大的极为所求的
     * @param array
     * @return
     */
    public int MoreThanHalfNum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int anArray : array) {
            if (!map.containsKey(anArray)) {
                map.put(anArray, 1);
            } else {
                int count = map.get(anArray);
                map.put(anArray, ++count);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (count > (array.length >> 1)) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MoreThanHalfNum_Solution ms = new MoreThanHalfNum_Solution();
        System.out.println(ms.MoreThanHalfNum(array));
    }

}
