/*
 * Copyright (C), 2015-2017
 * FileName: TestWeightedGraph
 * Author:   Administrator
 * Date:     2017/11/15 0015 20:32
 * Description: TestWeightedGraph
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈TestWeightedGraph〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public class TestWeightedGraph {
    public static void main(String[] args) {

        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "E:\\project\\java-Project\\AlgorithmsSolutions\\src\\me\\zonglun\\Graph\\testG1.txt";
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(8, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();

        System.out.println();

    }
}
