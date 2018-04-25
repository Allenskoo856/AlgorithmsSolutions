package me.zonglun.SwordToOffer;

/**
 * 二叉搜索树的后序遍历
 *
 * @author :  Administrator
 * @subject : 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @example :       8
 * 6  10         例如输入数组{5，7，6，9，11，10，8}
 * 5 7  9 11
 * @create 2018-03-17 13:52
 */
public class VerifySquenceOfBST {

    /**
     * 找住二叉查找树的特点：左子树<根<=右子树  使用分治思想
     * @param sequence
     * @return boolean
     */
    private static boolean VeritySquenceofBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return Verity(sequence, 0, sequence.length - 1);
    }

    /**
     * @param sequence 数组
     * @param start    数组开始元素的索引
     * @param end      数组结束元素的索引
     * @return boolean    true or false
     */
    private static boolean Verity(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 在二叉树搜索树中左节点小于根节点
        int i = start;
        while (sequence[i] < sequence[end]) {
            i++;        // 此时i = j < root 是数组中最后一个小于root的节点的临界值
        }
        // 在二叉树搜索树中右节点大于根节点
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;       // 如果在这个临界值的右边，有小于 root 的值，则不符合二叉搜索树的定义
            }
        }
        // 子树递归判断
        return Verity(sequence, start, i - 1) && Verity(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence2 = {7, 4, 6, 5};
        System.out.println(VeritySquenceofBST(sequence));
        System.out.println(VeritySquenceofBST(sequence2));
    }
}
