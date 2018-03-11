/*
 * Copyright (C), 2015-2017
 * FileName: Edge
 * Author:   Administrator
 * Date:     2017/11/15 0015 19:09
 * Description: 对有权图的类的边进行封装    
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈对有权图的类的边进行封装〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    private int a, b;
    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    public int V() {
        return a;
    }

    // 返回第二个元素
    public int W() {
        return b;
    }

    public Weight wt() {
        return weight;
    }

    public int other(int x) {
        assert x == a || x == b;
        return x == a ? b : a;
    }

    @Override
    public String toString() {
        return "" + a + "-" + b + ": " + weight;
    }

    @Override
    public int compareTo( Edge that) {
        if (weight.compareTo(that.weight) < 0)
            return -1;
        else if (weight.compareTo(that.weight) > 0)
            return +1;
        else
            return 0;
    }
}
