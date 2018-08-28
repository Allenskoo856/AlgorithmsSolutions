package me.zonglun.leetcode.linkedList.question234;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 回文链表
 *
 * @author : Administrator
 * @create 2018-08-28 19:54
 * @subject :
 *      请判断一个链表是否为回文链表。
 *     示例 1:
 *          输入: 1->2
 *          输出: false
 *     示例 2:
 *          输入: 1->2->2->1
 *          输出: true
 */
public class palindromelinkedlist {

    /**
     * 思路就是先找到中间的节点，然后反转，前后两端节点逐一对比
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
