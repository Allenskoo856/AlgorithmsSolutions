package me.zonglun.ProgrammerCodeInterviewGuide.Stack_Queue;

import java.util.Stack;

/**
 * @author xcalen
 * @subject
 *     1. 设计一个特殊的栈，在实现栈的基本功能上，再实现将输入的元素元素转序例如：输入1-2-3-4-5，入栈后栈顶到栈尾为：5-4-3-2-1：
 *     转序之后为：栈顶到栈尾 1-2-3-4-5
 * 	   2. 只能使用递归函数来实现，不能使用其他数据结构
 * @Strategies
 *
 */

public class ReverseStack {
    /*
     * 头一个函数是递归调用：效果是将栈底的元素返回，并且移除
     * */
    public static int getAndRemoveElement (Stack<Integer> stack) {
        int result = stack.pop(); // 得到栈顶的元素
        if (stack.isEmpty()) {		// 如果栈为空---则返回结果此时栈顶跟栈底的元素为同一值
            return result;
        }else {
            int last = getAndRemoveElement(stack); // 递归调用直到栈为空
            stack.push(result);					 // 把不是栈底的其他元素放回栈中去
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public void testReverseStact (){
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.print(test.pop() + " ");
        }
    }
}
