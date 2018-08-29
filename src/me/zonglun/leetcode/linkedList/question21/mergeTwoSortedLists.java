package me.zonglun.leetcode.linkedList.question21;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 合并两个有序的链表
 *
 * @author : Administrator
 * @create 2018-08-29 17:10
 * @subject :
 *      将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *      示例：
 *
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 */
public class mergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 如果l1有剩余，单独将它接到后面
        if (l1 != null) {
            cur.next = l1;
            // 如果l2有剩余，单独将他接到后面
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
