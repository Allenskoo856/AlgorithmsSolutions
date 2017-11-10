/*
 * Copyright (C), 2015-2017
 * FileName: UnionFind1
 * Author:   Administrator
 * Date:     2017/11/10 0010 21:22
 * Description: UnionFind1 第一版本    
 */

package me.zonglun.UnionFind;

/**
 * 〈一句话功能简述〉<br>
 * 〈UnionFind1 第一版本〉
 *
 * @author Administrator
 * @create 2017/11/10 0010
 * @since 1.0.0
 */
public class UnionFind1 {
    private int[] id;
    private int count;

    public UnionFind1(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    // 查找过程, 查找元素p所对应的集合编号
    // O(1)复杂度
    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }
    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (qID == pID)
            return;
        for (int i = 0; i < count; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        // 虽然isConnected只需要O(1)的时间, 但由于union操作需要O(n)的时间
        // 总体测试过程的算法复杂度是O(n^2)的
        UnionFindTestHelper.testUF1(n);
    }
}
