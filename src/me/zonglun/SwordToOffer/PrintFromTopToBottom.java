package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

import java.util.ArrayList;

/**
 * 从上往下打印二叉树
 *
 * @author : Administrator
 * @subject :  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @example ：对于树：     8
 * 6  10
 * 5 7 9 11      8——>6-> 10->5->7->9->11
 * @create 2018-03-17 12:45
 */
public class PrintFromTopToBottom {

    /**
     * 考虑到可以采用队列的先进先出来实现功能
     * 每打印一个节点，如果该结点有子节点，则把该节点的子节点放到队列的队尾，
     * 接下来到队列的头部节点取出来，重复以上的打印过程
     *
     * @param root TreeNode
     * @return ArrayList
     */
    public ArrayList<Integer> printFromTopToBottomInBinaryTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> deque = new ArrayList<>();

        if (root == null) {
            return list;
        }

        deque.add(root);
        while (deque.size() != 0) {
            TreeNode temp = deque.remove(0);   // 移除索引为1 的值
            if (temp.left != null) {
                deque.add(temp.left);
            }
            if (temp.right != null) {
                deque.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
