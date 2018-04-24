/*
 * Copyright (C), 2015-2017
 * FileName: UnionFind2
 * Author:   Administrator
 * Date:     2017/11/10 0010 21:51
 * Description: UnionFind1    
 */

package me.zonglun.UnionFind;

/**
 * 〈一句话功能简述〉<br>
 * 〈UnionFind1〉
 *
 * @author Administrator
 * @create 2017/11/10 0010
 * @since 1.0.0
 */
public class UnionFind2 {

    // 我们的第二版Union-Find, 使用一个数组构建一棵指向父节点的树
    // parent[i]表示第一个元素所指向的父节点
    private int[] parent;
    private int count;   // 数据个数

    public UnionFind2(int count) {
        parent = new int[count];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    private int find(int p) {
        assert (p >= 0 && p < count);
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    boolean isConneted(int q, int p) {
        return find(q) == find(p);
    }

    void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        parent[pRoot] = qRoot;
    }

    public static void main(String[] args) {
        int n = 100000;
         UnionFindTestHelper.testUF2(n);
    }
}
