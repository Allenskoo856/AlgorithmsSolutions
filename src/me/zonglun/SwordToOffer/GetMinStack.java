/*
 * Copyright (C), 2015-2017
 * FileName: GetMinStack
 * Author:   Administrator
 * Date:     2017/11/16 0016 16:38
 * Description: 剑指offer---在栈中得到最小的元素    
 */

package me.zonglun.SwordToOffer;

import edu.princeton.cs.algs4.Stack;
import org.jetbrains.annotations.TestOnly;

/**
 * 〈一句话功能简述〉<br>
 * 〈剑指offer---在栈中得到最小的元素〉
 * @author xcalen
 * @subject
 *     1. 设计一个特殊的栈，在实现栈的基本功能上，再实现返回栈的最小值的功能
 * 	   2. pop, push, getMIn操作时间复杂度为O（1）
 * 	   3. 时间限制：1秒 空间限制：32768K
 * @Strategies
 * 		设计上使用两个栈，一个用来保存当前栈中的元素--StackData；另一个栈用于保存每一步之中的最小值--记为StackMin
 */
public class GetMinStack {

    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void  push(int node) {
        if (stackMin.isEmpty())
            stackMin.push(node);
        else if (node <= this.min())
            stackMin.push(node);
        stackData.push(node);
    }

    public void pop() {
        if (!stackData.isEmpty()){
           int num = stackData.pop();
           if (num == this.min())
               stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        if (stackMin.isEmpty())
            return -1;
        return stackMin.peek();
    }

    @TestOnly
    public static void main(String[] args) {
        GetMinStack ps = new GetMinStack();
        ps.push(34);
        ps.push(12);
        ps.push(90);
        ps.push(4);
        System.out.println(ps.min());
    }
}
