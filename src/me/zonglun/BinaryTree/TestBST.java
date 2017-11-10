/*
 * Copyright (C), 2015-2017
 * FileName: TestBST
 * Author:   Administrator
 * Date:     2017/11/10 0010 10:03
 * Description: 对BST前中后续遍历进行测试    
 */

package me.zonglun.BinaryTree;

/**
 * 〈一句话功能简述〉<br>
 * 〈对BST前中后续遍历进行测试〉
 *
 * @author Administrator
 * @create 2017/11/10 0010
 * @since 1.0.0
 */
public class TestBST {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        // 取n个取值范围在[0...m)的随机整数放进二分搜索树中
        int N = 10;
        int M = 100;
        for(int i = 0 ; i < N ; i ++){
            Integer key = (int) (Math.random() * M);
            // 为了后续测试方便,这里value值取和key值一样
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // 测试二分搜索树的前序遍历 preOrder
        System.out.println("preOrder: ");
        bst.preOder();
        System.out.println();

        // 测试二分搜索树的中序遍历 inOrder
        System.out.println("inOrder: ");
        bst.inOder();
        System.out.println();

        // 测试二分搜索树的后序遍历 postOrder
        System.out.println("postOrder: ");
        bst.postOder();
        System.out.println();

        // 测试二分搜索树的层序遍历 levelOrder
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();
    }
}
