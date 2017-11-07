package me.zonglun.Stack_Queue;

import java.util.Stack;

/**
 * @author xcalen
 * @subject
 *     1. 设计一个特殊的栈，在实现栈的基本功能上，再实现返回栈的最小值的功能
 * 	   2. pop, push, getMIn操作时间复杂度为O（1）
 * @Strategies
 * 		设计上使用两个栈，一个用来保存当前栈中的元素--StackData；另一个栈用于保存每一步之中的最小值--记为StackMin
 */

public class GetMinStack {

	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public GetMinStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (this.stackMin.isEmpty()) { //最小栈为空，则压入
			this.stackMin.push(newNum);
		}else if (newNum <= this.getMin()) {	// 后来的程序比前面的最小栈要小，则压入
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);  // 实际栈总是压入元素
	}

	public int pop() {
		if (this.stackData.isEmpty()){  // 实际栈为空，报错
			throw new RuntimeException("Your stack is Empty");
		}
		int num = this.stackData.pop(); // 如果实际栈出栈的元素与最小栈相同，则一并弹出
		if (num == this.getMin()){
			this.stackMin.pop();
		}
		return num;
	}

	public  int getMin() {
		if (this.stackMin.isEmpty()){
			throw new RuntimeException("your stack is Empty");
		}
		return this.stackMin.peek(); // 最小栈的栈顶元素就是整个栈中的最小元素
	}

	@SuppressWarnings("unused")
	public void testMinStack() {
		int[]  arr = {7,4,5,6,5};
		GetMinStack mst = new GetMinStack();
		for (int i : arr) {
			mst.push(i);
		}
		System.out.println(mst.getMin());
	}

}
