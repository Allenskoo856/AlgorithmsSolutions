package me.zonglun.leetcode.linkedList.question142;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 环形链表2
 *
 * @author : Administrator
 * @create 2018-08-27 16:06
 * @subject :
 *      给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 *      说明：不允许修改给定的链表。
 *
 *  进阶：
 *      你是否可以不用额外空间解决此题？
 */
public class linkedlistcycleii {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode fast2 = head;
                while (fast2 != slow) {
                    fast2 = fast2.next;
                    slow = slow.next;
                }
                return fast2;
            }
        }
        return null;
    }
}
