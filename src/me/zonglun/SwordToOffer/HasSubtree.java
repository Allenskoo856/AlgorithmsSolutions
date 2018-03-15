package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 树的子结构
 *
 * @author : Administrator
 * @create 2018-03-15 13:16
 * @subject 输入两棵二叉树A，B，判断B是不是A的子结构（ps：我们约定空树不是任意一个树的子结构)，树的子结构
 */
public class HasSubtree {

    /**
     * 分两步，第一步在树A中查找与该根节点一样的值的节点R，第二步再来判断树A之中，以R为根节点的子树是否包含和根节点一样的结构
     *
     * @param root1
     * @param root2
     * @return boolean
     */
    private boolean HasSubtreeInBinaryTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = HasSubtreeInBinaryTree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtreeInBinaryTree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * 辅助函数，判断传入的root1 是否包含root2
     *
     * @param root1
     * @param root2
     * @return boolean
     */
    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
