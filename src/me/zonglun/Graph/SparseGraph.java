/*
 * Copyright (C), 2015-2017
 * FileName: SparseGraph
 * Author:   Administrator
 * Date:     2017/11/12 0012 21:59
 * Description: SparseGraph 稀疏图利用邻接表来实现    
 */

package me.zonglun.Graph;

import java.util.Vector;

/**
 * 〈一句话功能简述〉<br>
 * 〈SparseGraph 稀疏图利用邻接表来实现〉
 *
 * @author Administrator
 * @create 2017/11/12 0012
 * @since 1.0.0
 */
public class SparseGraph {
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;    // 是否为有向图
    private Vector<Integer>[] g;     // 图的具体数据

    public SparseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;     // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        this.g = new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }

    // 返回节点的个数
    public int V() {
        return n;
    }

    // 返回图中边的个数
    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        g[v].add(w);
        if (!directed)  // 如果为无向图，反向也要添加
            g[w].add(v);
        m ++;
    }
}
