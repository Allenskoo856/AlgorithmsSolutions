package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 二叉搜索树与双向链表
 *
 * @author : Administrator
 * @subject : 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *            要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @exapmle:        10
 *              6       14       4 <->6<->8<->10<->12<->14<->16
 *           4   8     12 16
 * @create 2018-03-18 16:00
 */
public class ConvertBSTToLinkList {

    /**
     *
     * @param pRootOfTree
     * @return  TreeNode
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInList = null;
        ConvertNode(pRootOfTree, pLastNodeInList);
        // PLastNode 是在链表的尾节点
        // 我们需要返回头节点
        TreeNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left != null) {
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private void ConvertNode(TreeNode pNode, TreeNode pLastNodeInList) {
        if (pNode == null) {
            return;
        }
        TreeNode currentNode = pNode;
        if (currentNode.left != null) {
            ConvertNode(currentNode.left, pLastNodeInList);
        }
        currentNode.left = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.right = currentNode;
        }
        pLastNodeInList = currentNode;

        if (currentNode.right != null) {
            ConvertNode(currentNode.right, pLastNodeInList);
        }
    }
}
