/*
 * Copyright (C), 2015-2017
 * FileName: WeightedGraph
 * Author:   Administrator
 * Date:     2017/11/15 0015 19:46
 * Description: WeightedGraph抽象接口
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br> 
 * 〈WeightedGraph抽象接口〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void addEdge(Edge<Weight> e);
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Edge<Weight>> adj(int v);
}
