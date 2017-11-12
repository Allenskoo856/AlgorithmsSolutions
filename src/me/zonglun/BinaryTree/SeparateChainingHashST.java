/*
 * Copyright (C), 2015-2017
 * FileName: SeparateChainingHashST
 * Author:   Administrator
 * Date:     2017/11/12 0012 16:47
 * Description: 基于拉链法的散列表    
 */

package me.zonglun.BinaryTree;


/**
 * 〈一句话功能简述〉<br>
 * 〈基于拉链法的散列表〉
 *
 * @author Administrator
 * @create 2017/11/12 0012
 * @since 1.0.0
 */
public class SeparateChainingHashST<Key ,Value> {
    private int N;  // 键值对总数
    private int M;  // 散列表大小
    private SequentialSearchST<Key, Value>[] st;   // 存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    private SeparateChainingHashST(int M) {
        //  创建M 条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }
    /*
       散列表的hash 函数
    * */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public static void main(String[] args) {
        SeparateChainingHashST<Integer, Integer> hashTable = new SeparateChainingHashST<>();
        int N = 100;
        int M = 10000;
        for (int i = 0; i < N; i++) {
            Integer key = (int) (Math.random() * M);
            Integer value = (int)(Math.random() * M);
            hashTable.put(key, value);
            hashTable.put(345,345900);
            long startTime = System.currentTimeMillis();
            int result = hashTable.get(345);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            System.out.println("the time is " + time + "result is " + result);
        }
    }
}
