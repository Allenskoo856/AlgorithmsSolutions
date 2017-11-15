/*
 * Copyright (C), 2015-2017
 * FileName: ShortestPath
 * Author:   Administrator
 * Date:     2017/11/15 0015 10:58
 * Description: 最短路径的求法    
 */

package me.zonglun.Graph;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈最短路径的求法〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public class ShortestPath {
    private Graph G;    // 图的引用
    private int s;       // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] ord;      // 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    // 构造函数
    public ShortestPath(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();
        visited = new  boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;
    }

    // 查询从s点到w点是否有路径
    public boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 无向图最短路径算法, 从s开始广度优先遍历整张图
    LinkedList<Integer> q = new LinkedList<>();
    
}
