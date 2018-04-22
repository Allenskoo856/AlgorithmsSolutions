package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * @author : Administrator
 * @subject :输入一棵二叉树，求该树的深度。
 *      从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @create 2018-04-22 11:07
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int TLeft = TreeDepth(root.left);
        int TRight = TreeDepth(root.right);
        return (TRight > TLeft) ? (TRight + 1) : (TLeft + 1);
    }

}
