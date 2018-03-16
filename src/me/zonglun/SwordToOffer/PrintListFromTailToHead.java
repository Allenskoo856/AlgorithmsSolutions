/*
 * Copyright (C), 2015-2017
 * FileName: PrintListFromTailToHead
 * Author:   Administrator
 * Date:     2017/11/16 0016 22:02
 * Description: 输入一个链表，从尾到头打印链表每个节点的值。    
 */

package me.zonglun.SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈输入一个链表，从尾到头打印链表每个节点的值。〉
 *@subject 输入一个链表，从尾到头打印链表每个节点的值
 * @Strategies
 *           思路：1. 可以借用栈的后进先出来实现 从尾到头的打印
 *           思路2： 使用递归来实现
 * @author Administrator
 * @create 2017/11/16 0016
 * @since 1.0.0
 */
public class PrintListFromTailToHead {

    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<Integer> printList(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;   // 维护指针指向后一个
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        // System.out.println(list);
        return list;
    }

    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Integer> printList2(ListNode listNode) {
        if (listNode != null) {
            this.printList2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printList(node1);
    }

}
