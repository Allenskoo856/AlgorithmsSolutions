
package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈输入一个链表，从尾到头打印链表每个节点的值。〉
 *
 * @author Administrator
 * @subject    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *             假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *             例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Strategies
 * @create 2017/11/16 0016
 * @since 1.0.0
 */
public class ReConstructBinaryTree {


    public TreeNode reConstructionTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 重建二叉树的核心函数 以一颗子树为根节点分别递归调用，重构二叉树，需要注意臂长和区间范围
     * @param pre   这颗子树的前序遍历
     * @param startPre  前序遍历中开始的节点
     * @param endPre    前序遍历中结束的节点
     * @param in        这颗子树的中序遍历
     * @param startIn   中序遍历中开始的节点
     * @param endIn     中序遍历中结束的节点
     * @return  TreeNode 返回这颗子树的根节点
     */
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 找到这颗子树的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
