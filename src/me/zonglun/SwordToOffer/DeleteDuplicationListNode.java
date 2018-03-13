

package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.ListNode;


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
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;    // 只有0个或1个结点，则返回
        }

        //  当前结点是重复结点
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

    /**
     * 使用非递归来实现功能
     * @param pHead
     * @return  ListNode
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        // 新建一个头节点防止，第一个节点被删除
        ListNode newNode = new ListNode(-1);
        newNode.next = pHead;
        ListNode pre = newNode;
        ListNode p = pHead;
        ListNode next = null;
        while (p != null && p.next != null) {
            next = p.next;
            //如果当前节点的值和下一个节点的值相等
            if (p.val == next.val) {
                while (next != null && next.val == p.val) {
                    next = next.next; // 指针继续后移,直到找到所有的重复的值
                }
                pre.next = next; // 指针赋值直到最后一个重复的值为止，可视为删除多余的节点
                p = next;
            } else {        //如果当前节点和下一个节点值不等，则向后移动一位
                pre = p;
                p = p.next;     // 指针继续后移
            }
        }
        return newNode.next;
    }

}
