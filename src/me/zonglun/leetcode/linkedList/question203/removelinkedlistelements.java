package me.zonglun.leetcode.linkedList.question203;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 删除链表中给定元素的节点
 *
 * @author : Administrator
 * @create 2018-08-28 16:53
 * @subject :
 *      删除链表中等于给定值 val 的所有节点。
 *      示例:
 *
 *      输入: 1->2->6->3->4->5->6, val = 6
 *      输出: 1->2->3->4->5
 */
public class removelinkedlistelements {


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                // 删除
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
