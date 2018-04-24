package me.zonglun.SwordToOffer;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 *
 * @author : Administrator
 * @subject : 从扑克牌中随机抽5张牌， 判断是不是一个顺子，既这5张牌是不是连续的。
 *      其中：2~10 为数字的本身，A为1，J为11， Q为12，K为13，然而大王和小王可以看成是任意的数字
 * @create 2018-04-24 14:59
 */
public class IsContinuous {

    /**
     * 满足5张牌是否为顺子的几个条件
     *  1. 数组的长度必须为5
     *  2. 数组中除了0之外，没有其他的重复的数字（或者说是牌）
     *  3. 这个数组中的最大值-最小值 < 5
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        int numOfZero = 0;
        int numOfInterval = 0;
        Arrays.sort(numbers);
        for (int num : numbers) {
            if (num == 0) {
                numOfZero++;
            }
        }
        for (int i = numOfZero; i < numbers.length - 1; i++) {
            // 出现非零的重复的数字就false
            if (numbers[i] != 0 && numbers[i] == numbers[i + 1]) {
                return false;
            }
            // 得到相邻数字中的间隔的位置
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        System.out.println(numOfZero);
        System.out.println(numOfInterval);
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 2, 4, 6};
        int[] array2 = {0, 0, 2, 3, 4,7};
        int[] array3 = {0, 0, 2, 3, 5};
        int[] array4 = {0, 3, 2, 6, 4};
        // System.out.println(new IsContinuous().isContinuous(array));
        // System.out.println(new IsContinuous().isContinuous(array2));
        // System.out.println(new IsContinuous().isContinuous(array3));
        System.out.println(new IsContinuous().isContinuous(array4));
    }
}
