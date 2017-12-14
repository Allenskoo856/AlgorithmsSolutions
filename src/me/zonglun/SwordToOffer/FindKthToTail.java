/*
 * Copyright (C), 2015-2017
 * FileName: FindKthToTail
 * Author:   Administrator
 * Date:     2017/12/14 0014 21:03
 * Description: 输入一个链表，输出该链表中倒数第k个结点。    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈输入一个链表，输出该链表中倒数第k个结点。〉
 *
 * @author Administrator
 * @subject 输入一个链表，输出该链表中倒数第k个结点。
 * @Strategies
 * @create 2017/12/14 0014
 * @since 1.0.0
 */
public class FindKthToTail {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        ListNode append(ListNode node) {
            this.next = node;
            return this;
        }

        @Override
        public String toString() {
           while (this.next != null)
               return
        }
    }

    public static ListNode find(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode pre = head;
        ListNode last = head;
        for (int i = 0; i < k; i++) {
            if (pre.next != null)
                pre = pre.next;
            else
                return null;
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(34);
        node.append(node1).append(node2).append(node3).append(node4);
        System.out.println(node);
        //System.out.println(FindKthToTail.find(node,2));
    }
}
