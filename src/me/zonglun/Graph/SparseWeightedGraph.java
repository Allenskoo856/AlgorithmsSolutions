/*
 * Copyright (C), 2015-2017
 * FileName: SparseWeightedGraph
 * Author:   Administrator
 * Date:     2017/11/15 0015 19:48
 * Description: SparseWeightedGraph    
 */

package me.zonglun.Graph;

import java.util.Vector;

/**
 * 〈一句话功能简述〉<br>
 * 〈SparseWeightedGraph〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;   // 是否为有向图
    private Vector<Edge<Weight>>[] g;   // 图的具体数据

    // 初始化的过程
    public SparseWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (Vector<Edge<Weight>>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }


    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    // 向图中添加一个边, 权值为weight
    public void addEdge(Edge e){

        assert e.V() >= 0 && e.V() < n ;
        assert e.W() >= 0 && e.W() < n ;

        // 注意, 由于在邻接表的情况, 查找是否有重边需要遍历整个链表
        // 我们的程序允许重边的出现

        g[e.V()].add(new Edge(e));
        if( e.V() != e.W() && !directed )
            g[e.W()].add(new Edge(e.W(), e.V(), e.wt()));
        m ++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        for( int i = 0 ; i < g[v].size() ; i ++ )
            if( g[v].elementAt(i).other(v) == w )
                return true;
        return false;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ){
                Edge e = g[i].elementAt(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
