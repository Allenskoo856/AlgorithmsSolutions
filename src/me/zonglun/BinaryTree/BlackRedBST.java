/*
 * Copyright (C), 2015-2017
 * FileName: BlackRedBST
 * Author:   Administrator
 * Date:     2017/11/11 0011 16:22
 * Description: 平衡二叉树---红黑树的实现    
 */

package me.zonglun.BinaryTree;

/**
 * 〈一句话功能简述〉<br>
 * 〈平衡二叉树---红黑树的实现〉
 * 红黑树的应用比较广泛，主要是用它来存储有序的数据，它的时间复杂度是O(lgn)，效率非常之高。
 * 例如，Java集合中的TreeSet和TreeMap，C++ STL中的set、map，以及Linux虚拟内存的管理，都是通过红黑树去实现的
 * you can see more details in https://www.cnblogs.com/skywang12345/p/3624343.html
 * 推荐一个较好数据结构算法讲解：http://www.cnblogs.com/skywang12345/p/3603935.html
 * 推荐书籍 ： 算法（第四版）https://book.douban.com/subject/19952400/
 *
 * @author Administrator
 * @create 2017/11/11 0011
 * @since 1.0.0
 */
public class BlackRedBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    // 私有内部类
    private class Node {
        private Key key;    // 键
        private Value value;    //值
        private Node left, right; // 左右节点
        private boolean color;  // 父节点指向他的链接的颜色
        private int N;      // 这颗子树中的节点总数

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    // 检查红黑树的节点是否为红,是的话返回true
    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == RED;
    }

    /*
    * 左旋操作，主要的目的是交换 根节点 和 右子树的位置(两者为红黑树)，
    * 并且进一步的保存红黑树的性质
    * 返回的是左旋之后的根节点
    * */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /*
   * 左旋操作，主要的目的是交换 根节点 和 左子树的位置(两者为红黑节点)，
   * 并且进一步的保存红黑树的性质
   * 返回的是右旋之后的根节点
   * */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /*
     *   改变节点的颜色，使得根节点为红色，
    *    它的左右节点为黑色
    *    ---所有的根节点 左右节均取反
    * */
    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.N;
    }

    // 返回整个红黑树的节点个数
    public int size() {
        return size(root);
    }

    // 放入元素方法--key ， 树中存在则-跟新值，不存在就插入新元素--并维护红黑树性质
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK; // 每次插入始终维护红黑树的根节点为黑色
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)   // 如果红黑树里面没有要放入的值，则新创建一个，并且和父节点用红链链接，放在树底
            return new Node(key, value, 1, RED);
        if (key.compareTo(node.key) < 0)    // 如果值比根节点要小，在左递归树中继续递归
            node.left = put(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = put(node.right, key, value); // 如果值比根节点要大，在左递归树中继续递归
        else
            node.value = value; // 如果相等就意味着找到了，直接更新值就可以
        /*
        * 旋转操作的三个要点：
        *   1. 如果右子节点为红色，而左子节点为黑色，则进行左旋转操作
        *   2. 如果左子节点是红色的，且它的左子结点也是红色的，则进行右旋转
        *   3. 如果左右子节点均为红色，则进行颜色转换。
        * */
        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);
        node.N = size(node.left) + size(node.right) + 1; // 更之后的节点数量
        return node;

    }

    /*
    根据键值对 查找元素
    返回根据键值对的值，没有就是null
    * */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0)
            return get(node.left, key);
        else if (key.compareTo(node.key) > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    // 返回整个红黑二叉树的最大的值
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    // 返回整个红黑二叉树的最小的值
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return null;
        if (!isRed(node.left) && !isRed(node.left.left))    // 如果左子节点 和孙子节点都为黑
            node = moveRedLeft(node);
        node.left = deleteMin(node.left);
        return balance(node);
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node balance(Node node) {
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    // Exercise 3.3.40
    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
        }
        return h;
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (root != null)
            root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);
        if (h.right == null)
            return null;
        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    // Exercise 3.3.41
    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (root != null)
            root.color = BLACK;
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left))
                node = moveRedLeft(node);
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left))
                node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && node.right == null)
                return null;
            if (!isRed(node.right) && !isRed(node.right.left))
                node = moveRedRight(node);
            if (key.compareTo(node.key) == 0) {
                node.value = get(node.right, min(node.right).key);
                node.key = min(node.right).key;
                node.right = deleteMin(node.right);
            } else
                node.right = delete(node.right, key);
        }
        return balance(node);
    }
}
