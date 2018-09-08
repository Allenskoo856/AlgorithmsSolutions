/*
 * Copyright (C), 2015-2017
 * FileName: SequentialSearchST
 * Author:   Administrator
 * Date:     2017/11/12 0012 16:51
 * Description: 链式查找链表的显示    
 */

package me.zonglun.BinaryTree;


import sun.misc.Queue;

/**
 * 〈一句话功能简述〉<br>
 * 〈链式查找链表的显示〉
 *
 * @author Administrator
 * @create 2017/11/12 0012
 * @since 1.0.0
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N = 0;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }


    public int size() {
        return N;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (x.key.equals(key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return (Iterable<Key>) queue;
    }
}

