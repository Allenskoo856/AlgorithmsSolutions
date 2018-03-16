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
 *      两个指针，先让第一个指针和第二个指针都指向头结点，
 *      然后再让第一个指正走(k-1)步，到达第k个节点。然后两个指针同时往后移动，
 *      当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
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
    }

    public static ListNode find(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
