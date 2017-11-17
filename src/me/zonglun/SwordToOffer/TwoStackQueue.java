/*
 * Copyright (C), 2015-2017
 * FileName: TwoStackQueue
 * Author:   Administrator
 * Date:     2017/11/16 0016 21:20
 * Description: TwoStackQueue    
 */

package me.zonglun.SwordToOffer;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈TwoStackQueue〉
 * @subject 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @Strategies
 *      1. 设计上使用两个栈，一个只能用来压入栈--StackPush；另一个栈只能弹出栈--记为StackPop;
 *      2. 栈的特点是先进后出，队列先进先出，可用来将数据存入压入栈如 1-2-3-4-5  StackPush：5-4-3-2-1 再把Stackpush的值压入StackPop  变为：Stackpop：1-2-3-4-5 这样从Stackpop里弹出的顺序和向Stackpush压入的顺序则完全一致。
 *      3. 注意两点：（1）Stackpush往Stackpop完全压入的时候必须一次性压入，不能出现剩余数据
 *                  （2）如果Stackpop不为空，则不能出现压栈操作
 * @author Administrator
 * @create 2017/11/16 0016
 * @since 1.0.0
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    public void push(int node) {
        stackPush.push(node);
    }

    public int pop(){
        if (stackPush.empty() && stackPop.empty())
            throw new RuntimeException("Queue is Empty");
        if (stackPop.empty()){
            while (!stackPush.empty())
                stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue que = new TwoStackQueue();
        que.push(34);
        que.push(23);
        que.push(245);
        System.out.println(que.pop());
    }
}
