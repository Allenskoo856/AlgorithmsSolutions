package me.zonglun.SwordToOffer;

import me.zonglun.SwordToOffer.util.TreeNode;

/**
 * 序列化二叉树
 *
 * @author : Administrator
 * @create 2018-07-03 11:04
 * @subject :
 *      请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeBinaryTree {

    public int index = -1;

    /**
     * 序列化二叉树--将二叉树序列化为字符串
     *  算法思想：根据前序遍历规则完成序列化和反序列化。
     *  所谓的序列化指的是遍历二叉树为字符串：所谓的反序列化指的是根据字符串重新构造成二叉树。
     *  前序遍历是从根节点开始的。当在遍历二叉树碰到null 的时候将其初始化为字符串“#”，
     *  各个节点的数值用逗号隔开，
     * @param root
     * @return
     */
    String serializeBinary(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serializeBinary(root.left));
        sb.append(serializeBinary(root.right));
        return sb.toString();
    }

    /**
     * 反序列化二叉树--将字符串转化为二叉树
     *
     * @param str
     * @return
     */
    TreeNode Deseriallize(String str) {
        index++;
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deseriallize(str);
            node.right = Deseriallize(str);
        }
        return node;
    }

}
