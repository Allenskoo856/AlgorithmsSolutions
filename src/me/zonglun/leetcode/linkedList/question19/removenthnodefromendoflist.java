package me.zonglun.leetcode.linkedList.question19;

import me.zonglun.SwordToOffer.util.ListNode;

/**
 * 删除链表的倒数第N个节点
 *
 * @author : Administrator
 * @create 2018-08-27 16:09
 * @subject :
 *      给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *      示例：
 *
 *          给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 *          当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *     说明：
 *       给定的 n 保证是有效的。
 */
public class removenthnodefromendoflist {

    /**
     * 方法1 ： 使用两步遍历法则，
     * 这个问题可以容易地简化成另一个问题：删除从列表开头数起的第 (L - n + 1)(L−n+1) 个结点，
     * 其中 LL 是列表的长度。只要我们找到列表的长度 LL，这个问题就很容易解决。
     * 首先我们将添加一个哑结点作为辅助，该结点位于列表头部。
     * 哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。
     * 在第一次遍历中，
     * 我们找出列表的长度 L。然后设置一个指向哑结点的指针，并移动它遍历列表，
     * 直至它到达第 (L -n) 个结点那里。
     * 我们把第 (L−n) 个结点的 next 指针重新链接至第 (L−n+2) 个结点，完成这个算法。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode frist = head;
        while (frist != null) {
            length++;
            frist = frist.next;
        }
        length -= n;
        frist = dummy;
        while (length > 0) {
            length--;
            frist = frist.next;
        }
        frist.next = frist.next.next;
        return dummy.next;
    }

    /**
     * 我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1n+1 步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 nn 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthNode2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 向前移动n个指针，使得其前一个指针移动的距离是后面的n个
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 删除倒数第n个节点
        second.next = second.next.next;
        return dummy.next;
    }
}
