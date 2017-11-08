/*
 * Copyright (C), 2015-2017
 * FileName: BST
 * Author:   Administrator
 * Date:     2017/11/8 0008 11:01
 * Description: 二分搜索树    
 */

package me.zonglun.BinaryTree;

/**
 * 〈一句话功能简述〉<br>
 * 〈二分搜索树〉
 *
 * @author Administrator
 * @create 2017/11/8 0008
 * @since 1.0.0
 */
public class BST<Key extends Comparable, Value> {
    // 新建内部类
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        // Node 的构造函数
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;  // 根节点
    private int count;   // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }
    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }


}
