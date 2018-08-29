package me.zonglun.leetcode.linkedList.question138;

import me.zonglun.leetcode.utils.RandomListNode;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 *
 * @author : Administrator
 * @create 2018-08-29 15:59
 * @subject :
 *
 *      给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 *      要求返回这个链表的深度拷贝。
 */
public class copylistwithrandompointer {

    /**
     *  给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     *  用hash存储random节点的下标映射关系，拷贝列表，并根据映射关系对random复原
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        // 复制节点
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        // 复制随机拷贝指针
        head = dummy.next;
        while (head != null) {
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return map.get(dummy.next);
    }
}
