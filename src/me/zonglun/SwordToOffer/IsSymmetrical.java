package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 对称的二叉树
 *
 * @author : Administrator
 * @create 2018-07-01 16:43
 * @subject :
 *  请实现一个函数，用来判断一颗二叉树是不是对称的。
 *  注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {

    /**
     * 符合递归的信息来看应该满足以下的结果：
     *   1. 根节点相同，根节点的左子树的左节点和右子树的右节点相同
     *   2. 左子树的右结点和右子树的左结点相同
     *   3. 递归循环即可
     * @param pRoot
     * @return
     */
    public boolean check(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return checkChildTree(pRoot.left, pRoot.right);
    }

    /**
     * 递归判断左子树和右子树
     * @param nodeLeft
     * @param nodeRight
     * @return
     */
    private boolean checkChildTree(TreeNode nodeLeft, TreeNode nodeRight) {
        // 左节点为空，则右节点必须为空
        if (nodeLeft == null) {
            return nodeRight == null;
        }
        // 左节点不为空，右节点为空，不为镜像二叉树
        if (nodeRight == null) {
            return false;
        }
        // 如果左右节点不相等错误
        // （此时的左右节点应该赋值为左子树的左节点和右子树的右节点
        //  或者 左子树的右结点和右子树的左结点）
        if (nodeLeft.val != nodeRight.val) {
            return false;
        }
        return checkChildTree(nodeLeft.left, nodeRight.right) && checkChildTree(nodeLeft.right, nodeRight.left);
    }
}
