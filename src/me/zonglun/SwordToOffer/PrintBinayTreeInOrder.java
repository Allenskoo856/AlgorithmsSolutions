package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 顺序打印二叉树
 *
 * @author : Administrator
 * @create 2018-07-02 21:03
 * @subject :
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintBinayTreeInOrder {

    /**
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        // 使用队列，先进先出
        Queue<TreeNode> layer = new LinkedList<>();
        // 存放每行的列表
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        // 记录本层打印了多少个, 记录下层打几个
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            TreeNode temp = layer.remove();
            // 添加到本行的arrayList
            layerList.add(temp.val);
            start++;
            // 每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if(temp.left!=null){
                layer.add(temp.left);
            }
            if(temp.right!=null){
                layer.add(temp.right);
            }
            // 判断本层打印是否完成
            if (start == end) {
                // 此时的queue中存储的都是下一层的节点，则end即为queue大小
                end = layer.size();
                start = 0;
                // 把arrayList添加到结果列表arrayLists中
                result.add(layerList);
                // 重置arrayList
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }

    private TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

}
