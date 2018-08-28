package me.zonglun.leetcode.linkedList.question160;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 求两个链表的相交的节点
 *
 * @author : Administrator
 * @create 2018-08-27 16:00
 * @subject :
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <p>
 * <p>
 * 例如，下面的两个链表：
        A:          a1 → a2
                            ↘
                            c1 → c2 → c3
                            ↗
        B:      b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenthA = length(headA), lengthB = length(headB);
        while (lenthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }
        while (lenthA > lengthB) {
            headA = headA.next;
            lenthA--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
