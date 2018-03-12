

package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.ListNode;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈链表中环的节点〉
 *
 * @author Administrator
 * @subject  在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *              例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Strategies
 * @create 2018/3/11 0011
 * @since 1.0.0
 */
public class DeleteDuplicationListNode {

    /**
     * 使用递归来实现删除重复节点的功能
     * @param pHead
     * @return
     */
    // todo false pass
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        //  // 当前结点是重复结点
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
        } else {        // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
    }
}
