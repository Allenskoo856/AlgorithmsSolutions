package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 双向链表
 *
 * @author : Administrator
 * @create 2018-08-25 16:09
 * @subject :
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class DoublylinkedList {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode head = null;
        if (pRootOfTree.left != null) {
            TreeNode h = Convert(pRootOfTree.left);
            head = h;
            while (h.right != null) {
                h = h.right;
            }
            h.right = pRootOfTree;
            pRootOfTree.left = h;
        }

        if (pRootOfTree.right != null) {
            TreeNode h = Convert(pRootOfTree.right);
            pRootOfTree.right = h;
            h.left = pRootOfTree;
        }

        return head != null ? head : pRootOfTree;
    }
}
