package me.zonglun.leetcode.linkedList.question86;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 分割链表
 *
 * @author : Administrator
 * @create 2018-08-29 11:47
 * @subject :
 *      给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 *      你应当保留两个分区中每个节点的初始相对位置。
 *      示例:
 *              输入: head = 1->4->3->2->5->2,  x = 3
 *              输出: 1->2->2->4->3->5
 */
public class partitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode dummyhead1 = dummy1, dummyhead2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                dummyhead1.next = head;
                dummyhead1 = head;
            } else {
                dummyhead2.next = head;
                dummyhead2 = head;
            }
            head = head.next;
        }
        // 防止出现环节点的情况
        dummyhead2.next = null;
        dummyhead1.next = dummy2.next;
        return dummy1.next;
    }
}
