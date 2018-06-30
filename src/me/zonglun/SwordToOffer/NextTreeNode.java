package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeLinkNode;

/**
 * @author : Administrator
 * @create 2018-06-30 17:01
 * @subject :给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *          注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class NextTreeNode {

    /**
     * （1） 若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点 B ）
     * （2） 若该节点不存在右子树：这时分两种情况：
     *      2.1 该节点为父节点的左子节点，则下一个节点为其父节点
     *      2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，则该节点的父节点下一个节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 节点有右子树 下一个节点为右子树最左子节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；
        // 否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
        while (pNode.next != null) {
            if (pNode == pNode.next.left) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
