package me.zonglun.Stack_Queue;

import java.util.Stack;

/**
 * @author xcalen
 * @subject
 *     1. ���һ�������ջ����ʵ��ջ�Ļ��������ϣ���ʵ�ַ���ջ����Сֵ�Ĺ���
 * 	   2. pop, push, getMIn����ʱ�临�Ӷ�ΪO��1��	
 * @Strategies 
 * 		�����ʹ������ջ��һ���������浱ǰջ�е�Ԫ��--StackData����һ��ջ���ڱ���ÿһ��֮�е���Сֵ--��ΪStackMin
 */

public class GetMinStack {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public GetMinStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum) {
		if (this.stackMin.isEmpty()) { //��СջΪ�գ���ѹ��
			this.stackMin.push(newNum);
		}else if (newNum <= this.getMin()) {	// �����ĳ����ǰ�����СջҪС����ѹ��
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);  // ʵ��ջ����ѹ��Ԫ��
	}
	
	public int pop() {
		if (this.stackData.isEmpty()){  // ʵ��ջΪ�գ�����
			throw new RuntimeException("Your stack is Empty");
		}
		int num = this.stackData.pop(); // ���ʵ��ջ��ջ��Ԫ������Сջ��ͬ����һ������
		if (num == this.getMin()){
			this.stackMin.pop();
		}
		return num;
	}
	
	public  int getMin() {
		if (this.stackMin.isEmpty()){
			throw new RuntimeException("your stack is Empty");
		}
		return this.stackMin.peek(); // ��Сջ��ջ��Ԫ�ؾ�������ջ�е���СԪ��
	}
	
}
