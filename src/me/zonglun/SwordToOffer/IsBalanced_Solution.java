package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author : Administrator
 * @subject : 输入一颗二叉树的根节点，判断该数是不是平衡二叉树，如果某二叉树中任意
 *      节点的左右字数的深度不超过1，则此为一颗平衡二叉数。
 * @create 2018-04-22 14:58
 */
public class IsBalanced_Solution {

    public boolean isbalanceTree(TreeNode root) {
        return getBalancedDepth(root) != -1;
    }

    /**
     * 如果二叉树每个节点的左字数和右子树的深度不大于1，它就是平衡二叉树
     * 直接利用左子树减去右子树取绝对值，值大于1整颗树都不为平衡二叉树赋值为-1,
     * 否则这颗树的深度就是左右子树的深度的最大值再加1（其本身根节点）
     * @param root
     * @return
     */
    private int getBalancedDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getBalancedDepth(root.left);
        int right = getBalancedDepth(root.right);
        if (left == -1) {
            return -1;
        }
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
