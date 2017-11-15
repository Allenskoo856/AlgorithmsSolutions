/*
 * Copyright (C), 2015-2017
 * FileName: Components
 * Author:   Administrator
 * Date:     2017/11/14 0014 10:53
 * Description: // 求无权图的联通分量    
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈// 求无权图的联通分量〉
 *
 * @author Administrator
 * @create 2017/11/14 0014
 * @since 1.0.0
 */
public class Components {
    Graph G;        // 图的引用
    private boolean[] visited; // 记录dfs的过程中节点是否被访问
    private int ccount;  //  记录联通分量个数
    private int[] id;   // 每个节点所对应的联通分量标记,相链接的ID的大小值是相同的

    public Components(Graph graph) {
        G = graph;
        visited = new boolean[G.V()];   //  visited 开辟新的空间，大小为图里面的节点个数
        id = new int[G.V()];    //  在 ID 里面开辟新的空间，大小为图里面的节点个数
        ccount = 0;
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;     // 初始化应该节点都没有被访问过
            id[i] = -1;         // 初始化的时候使得所有的元素的值为-1
        }

        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);     // 图的深度优先遍历-
                ccount++;
            }
        }
    }

    int getCount() {
        return ccount;
    }

    boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }

    // 图的深度优先遍历----递归实现
    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if (!visited[i])    // 如果已经被访问过了则继续循环
                dfs(i);         // 递归运行i
        }
    }
}
