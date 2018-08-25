package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeLinkNode;

/**
 * @author : Administrator
 * @Subject:    给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *              注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @create 2018-05-20 10:05
 */
public class GetNextTreeNode {

    /**
     * 中序遍历是指从先遍历左子树的节点-根节点-右子树的节点，每颗子树后面遍历顺序一致
     *
     *  （1） 若该节点存在右子树：则下一个节点为右子树最左子节点
     *   （2）若没有右子树
     *
     * @param pNode 节点
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
