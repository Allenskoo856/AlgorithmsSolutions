package me.zonglun.leetcode.linkedList.question23;

import me.zonglun.SwordToOffer.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 *
 * @author : Administrator
 * @create 2018-08-29 17:23
 * @subject :
 *      合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *      输入:
 *          [
 *              1->4->5,
 *              1->3->4,
 *              2->6
 *          ]
 *      输出: 1->1->2->3->4->4->5->6
 */
public class mergeksortedlists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
}
