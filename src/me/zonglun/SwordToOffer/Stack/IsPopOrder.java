/*
 * Copyright (C), 2015-2017
 * FileName: IsPopOrder
 * Author:   Administrator
 * Date:     2017/11/16 0016 19:46
 * Description: IsPopOrder    
 */

package me.zonglun.SwordToOffer.Stack;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈剑指offer---IsPopOrder〉
 *
 * @author Administrator
 * @create 2017/11/16 0016
 * @subject 1. 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
             * 假设压入栈的所有数字均不相等。
             * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
             * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *          2. 时间限制：1秒 空间限制：32768K
 * @Strategies
        借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，
        直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
        这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序
 * @since 1.0.0
 */
public class IsPopOrder {

    public   boolean isPopOrder(int[] pushA, int[] popA) {

        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        // //用于标识弹出序列的索引值
        int j = 0;
        for (int i = 0; i <=pushA.length -1; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[j]) {
                //出栈
                stack.pop();
                // 索引后移一位
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = { 3, 4, 5, 2, 1};
    }
}
