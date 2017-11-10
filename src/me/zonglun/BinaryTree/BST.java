/*
 * Copyright (C), 2015-2017
 * FileName: BST
 * Author:   Administrator
 * Date:     2017/11/8 0008 11:01
 * Description: 二分搜索树    
 */

package me.zonglun.BinaryTree;

import org.jetbrains.annotations.Contract;

import java.util.LinkedList;
import java.util.Objects;

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
    BST() {
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

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 查看二分搜索树中是否存在键key
    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Value search(Key key) {
        return search(root, key);
    }

    void preOder() {
        preOder(root);
    }

    void inOder() {
        inOder(root);
    }

    void postOder() {
        postOder(root);
    }

    // 对以node为根的二叉搜索树进行层序遍历, 递归算法
    void levelOrder() {
        // 我们使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(node.key + " ");
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }


    public Key maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    public Key minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // 返回以node为根的二分搜索树的最大键值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOder(node.left);
            preOder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private void inOder(Node node) {
        if (node != null) {
            inOder(node.left);
            System.out.print(node.key + " ");
            inOder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOder(Node node) {
        if (node != null) {
            postOder(node.left);
            postOder(node.right);
            System.out.print(node.key + " ");
        }
    }

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value) {
        // 如果对应的Key的值等于 节点的索引，等于即直接替换
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else
            node.right = insert(node.right, key, value);
        return node;
    }

    @Contract("null, _ -> false")
    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;
        if (node.key == key)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else
            return contain(node.right, key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    @Contract("null, _ -> null")
    private Value search(Node node, Key key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node.value;
        else if (key.compareTo(node.key) < 0)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    public static void main(String[] args) {
        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;
        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = arr[pos];
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < N; i++)
            bst.insert(arr[i], Integer.toString(arr[i]));
        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(i);
            if (i < N)
                assert Objects.equals(res, Integer.toString(i));
            else
                assert res == null;
        }

    }

}
