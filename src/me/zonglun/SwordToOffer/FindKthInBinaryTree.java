package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 找到二叉树的第K个节点
 *
 * @author : Administrator
 * @create 2018-08-21 20:17
 * @subject : 给定一颗二叉搜索树，请找出其中的第K小的节点。例如，（5，3，7，2，4，6，8）中，
 * 按结点数值大小顺序第三小结点的值为4
 */
public class FindKthInBinaryTree {
    // 计数器
    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }
}
