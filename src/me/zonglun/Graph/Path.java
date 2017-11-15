/*
 * Copyright (C), 2015-2017
 * FileName: Path
 * Author:   Administrator
 * Date:     2017/11/15 0015 10:01
 * Description: Path 图的路径的类    
 */

package me.zonglun.Graph;

import edu.princeton.cs.algs4.Stack;

import java.util.Vector;

/**
 * 〈一句话功能简述〉<br>
 * 〈Path 图的路径的类〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public class Path {
    private Graph G;    // 图的引用
    private int s;       // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;      // 记录路径, from[i]表示查找的路径上i的上一个节点

    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                from[i] = v;    // 没被访问的节点的值记为v， 存贮在from【i】的数组之中。
                dfs(i);
            }
        }
    }

    public Path(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();
        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        // 寻路算法
        dfs(s);
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> s = new Stack<>();
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        Vector<Integer> res = new Vector<Integer>();
        while (!s.isEmpty())
            res.add(s.pop());
        return res;
    }

    void showPath(int w) {
        assert hasPath(w);
        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size() - 1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
}
