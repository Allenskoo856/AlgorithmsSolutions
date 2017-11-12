/*
 * Copyright (C), 2015-2017
 * FileName: DenseGraph
 * Author:   Administrator
 * Date:     2017/11/12 0012 21:42
 * Description: 稠密图Java展示    
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈稠密图Java展示〉
 *
 * @author Administrator
 * @create 2017/11/12 0012
 * @since 1.0.0
 */
public class DenseGraph {

    private int n; // 节点数
    private int m;  // 边数
    private boolean directed; // 是否为有向图
    // 边的链接情况--用相邻界矩阵来表示
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // 刚开始是创建新的 n*n阶的矩阵，值都为false
        this.g = new boolean[n][n];
    }

    public int V() {
        return n;
    } // 返回节点的个数

    public int E() {
        return m;
    } // 返回图中边的个数

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, w))  // 判断是否图中已经有了相关的图，如有则返回
            return;
        g[v][w] = true;
        if (!directed)  // 如果不是无向图
            g[w][v] = true;
        m++;
    }

    private boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}
