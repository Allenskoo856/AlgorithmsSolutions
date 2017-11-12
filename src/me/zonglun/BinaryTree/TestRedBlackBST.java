/*
 * Copyright (C), 2015-2017
 * FileName: TesTRedBlackBST
 * Author:   Administrator
 * Date:     2017/11/12 0012 16:17
 * Description: 测试红黑树    
 */

package me.zonglun.BinaryTree;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试红黑树〉
 *
 * @author Administrator
 * @create 2017/11/12 0012
 * @since 1.0.0
 */
public class TestRedBlackBST {
    public static void main(String[] args) {
        BlackRedBST<Integer, Integer> Rb = new BlackRedBST<>();
        int N = 10;
        int M = 100;
        for (int i = 0; i < N; i++) {
            Integer key = (int) (Math.random() * M);
            Rb.put(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // 测试二分搜索树的size()
        System.out.println("size: " + Rb.size());
        System.out.println();
        System.out.println(Rb.max());
    }
}
