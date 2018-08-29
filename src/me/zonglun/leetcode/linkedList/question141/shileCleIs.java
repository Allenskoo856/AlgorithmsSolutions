package me.zonglun.leetcode.linkedList.question141;

import me.zonglun.SwordToOffer.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author : Administrator
 * @create 2018-08-27 16:04
 * @subject :
 *      给定一个链表，判断链表中是否有环。
 */
class shileCleIs {

    /**
     * 方法1：使用hash表来存贮所有判断链表是否为环形链表。常用的方法是使用哈希表。
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
     * 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），
     * 那么我们已经遍历完整个链表，并且该链表不是环形链表。
     * 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     * @param head
     * @return head
     * 时间复杂度：O(n)O(n)， 对于含有 nn 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1)O(1) 的时间。
     * 空间复杂度：O(n)O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 nn 个元素。
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 第二种方法，双指针法，
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
