package me.zonglun.leetcode.linkedList;

/**
 * 设计链表
 * 自定义单链表数据结构
 * @author : Administrator
 * @create 2018-08-26 14:36
 */
public class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (length == 0 || index > length - 1) {
            return -1;
        }
        if (index <= 0) {
            return head.val;
        }
        Node cur = head; // 定义一个node的pointer指向head
        int pointer = 1;
        while (pointer < index) {
            cur = cur.next;
            pointer++;
        }
        return cur.next.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        Node newNode = new Node(val);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node cur = head;
            int pointer = 1;
            while (pointer < index) {
                cur = cur.next;
                pointer++;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        length++; //这里不要忘记加1，别的函数调用的时候，也自动更新了length
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (length == 0 || index > length - 1 || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node cur = head;
            int pointer = 1;
            while (pointer < index && cur.next != null) {
                cur = cur.next;
                pointer++;
            }
            cur.next = cur.next.next;
        }
        length--;
    }

    /*
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
