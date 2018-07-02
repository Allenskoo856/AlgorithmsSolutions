package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Z字型打印二叉树
 *
 * @author : Administrator
 * @create 2018-07-02 10:35
 * @subject :
 *      请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeByZ {

    /**
     * 打印--就是对于一个二叉树而言：
     *   在奇数行是打印从左到右-- 打印
     *   在偶数行是从右到左打印---
     *   然后利用两个栈分别存贮奇数行和偶数行的节点
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        // 定义层级数 layer
        int layer = 1;
        // 栈1存贮奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        // s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()) {
            // 层数是奇数
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            // 层数是偶数
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.println(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}
