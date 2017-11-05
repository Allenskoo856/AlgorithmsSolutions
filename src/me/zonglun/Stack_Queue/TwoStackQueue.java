package me.zonglun.Stack_Queue;

import java.util.Stack;

/**
 * @author xcalen
 * @subject 1. 设计一个类，用两个栈实现队列，支持队列的基本操作（add，poll，peek）
 * @Strategies
 *      1. 设计上使用两个栈，一个只能用来压入栈--StackPush；另一个栈只能弹出栈--记为StackPop;
 *      2. 栈的特点是先进后出，队列先进先出，可用来将数据存入压入栈如 1-2-3-4-5  StackPush：5-4-3-2-1 再把Stackpush的值压入StackPop
 *          变为：Stackpop：1-2-3-4-5 这样从Stackpop里弹出的顺序和向Stackpush压入的顺序则完全一致。
 *      3. 注意两点：（1）Stackpush往Stackpop完全压入的时候必须一次性压入，不能出现剩余数据
 *                  （2）如果Stackpop不为空，则不能出现压栈操作
 */

public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    private TwoStackQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    /**
     * 从队列中添加元素
     */
    public void add(int arr) {
        stackPush.push(arr);
    }

    /**
     * 从队列中取元素直到队列为空
     */
    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Your TwoStackQueue is Empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 从队列中取出最先的元素
     */
    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Your TwoStackQueue is Empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


    public void testQueue() {
        int[] arr = {7, 1, 4, 5, 6, 5};
        TwoStackQueue que = new TwoStackQueue();
        for (int i : arr) {
            que.add(i);
        }
        System.out.println(que.peek());
        System.out.println(que.poll());
        System.out.println(que.peek());
        System.out.println(que.poll());
        System.out.println(que.peek());
        System.out.println(que.poll());
    }
}

