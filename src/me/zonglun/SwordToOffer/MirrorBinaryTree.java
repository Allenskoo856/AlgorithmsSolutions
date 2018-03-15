package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 二叉树的镜像
 *
 * @author :  Administrator
 * @subject: 操作给定的二叉树，将其变换为源二叉树的镜像
 * @create 2018-03-15 16:54
 */
public class MirrorBinaryTree {

    /**
     * 先前序遍历这颗树的每个节点，如果遍历到的结点有子节点，就交换它的两个子结点
     * 交换了完了所有的非叶子节点的左右子节点之后，得到镜像
     *
     * @param root
     */
    private void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 交换根节点的左右子节点
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
