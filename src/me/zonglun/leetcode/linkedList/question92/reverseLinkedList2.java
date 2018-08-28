package me.zonglun.leetcode.linkedList.question92;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 反转链表2
 *
 * @author : Administrator
 * @create 2018-08-26 20:44
 * @subject :
 *      反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 *      说明:
 *      1 ≤ m ≤ n ≤ 链表长度。
 *
 *      示例:
 *
 *      输入: 1->2->3->4->5->NULL, m = 2, n = 4
 *      输出: 1->4->3->2->5->NULL
 */
public class reverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
       if (head == null) return null;
       // create a dummy node to mark the head of this list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // make a pointer pre as a marker for the node before reversing
        ListNode pre = dummy;
        for (int i = 0; i < m -1; i++) {
            pre = pre.next;
        }
        // a pointer to the beginning of a sub-list that will be reversed
        ListNode start = pre.next;
        // a pointer to a node that will be reversed
        ListNode then = start.next;
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        // 反转过程采用尾插法，就是将start后面的节点逐步删除，后移到反转链表的头部
        for (int i = 0; i < n - m; i++) {
            // 第一步先删除 then节点
            start.next = then.next;
            // 第二步添加两个指针，pre后面的节点的中间
            then.next = pre.next;
            pre.next = then;
            // 最后跟新then的值使他始终指向start的后面
            then = start.next;
        }
        // at the begin :   dummy-> 1 -> 2 -> 3 -> 4 -> 5; pre = 1, start = 2, then = 3

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
}
