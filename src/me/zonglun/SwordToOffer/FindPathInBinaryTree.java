package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * @author : Administrator
 * @subject : 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *            路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @example:
 * @create 2018-03-18 14:20
 */
public class FindPathInBinaryTree {

    private ArrayList<ArrayList<Integer>> PathList = new ArrayList<>(); // 存放路径值

    /**
     * 用前序遍历的方式访问到某一节点值时候，把该节点添加到路径上，并且累加该节点的值，如果该节点为叶子节点并且路径中
     * 节点值的和恰好等于输入的整数，那么就符合路劲的要求，否则退回它的父节点，并将路径中的叶子节点删除，并且减去当前叶子节点的值
     * 可以看出保存路径的数据结构可以用栈来表示
     * @param root
     * @param target
     * @return  ArrayList<ArrayList<Integer>> 存贮的所有的节点路径
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return PathList;
        }
        find(PathList, new ArrayList<>(), root, target);
        return PathList;
    }

    private void find(ArrayList<ArrayList<Integer>> pathList, ArrayList<Integer> count, TreeNode root, int target) {
        count.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                pathList.add(count);
            }
            return;
        }
        ArrayList<Integer> count2 = new ArrayList<>(count);
        if (root.left != null) {
            find(pathList, count, root.left, target - root.val);
        }
        if (root.right != null) {
            find(pathList, count2 ,root.right, target - root.val);
        }
    }

}
