package me.zonglun.leetcode.linkedList.question206;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 反转链表
 *
 * @author : Administrator
 * @create 2018-08-26 13:04
 * @subject :
 *      反转一个单链表,不可额外的申请空间
 *      示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 *      你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class reverseLinkedList {

    /**
     * 迭代的方法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head; // 备份指正
            head = temp;
        }
        return pre;
    }

    /**
     * 递归的解决方法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
