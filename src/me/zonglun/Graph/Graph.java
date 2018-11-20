/*
 * Copyright (C), 2015-2017
 * FileName: Graph
 * Author:   Administrator
 * Date:     2017/11/13 0013 20:36
 * Description: Graph 图的接口
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈Graph 图的接口〉
 *
 * @author Administrator
 * @create 2017/11/13 0013
 * @since 1.0.0
 */
public interface Graph {
    int V();
    int E();
    void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    void show();
    Iterable<Integer> adj(int v);
}
