package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeLinkNode;

import java.util.ArrayList;

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
        // todo
        return null;
    }
}
