/*
 * Copyright (C), 2015-2017
 * FileName: TestGraph
 * Author:   Administrator
 * Date:     2017/11/13 0013 20:59
 * Description: nonnegative    
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试图例子〉
 *
 * @author Administrator
 * @create 2017/11/13 0013
 * @since 1.0.0
 */
public class TestGraph {
    public static void main(String[] args) {
        String fileName = "E:\\project\\java-Project\\AlgorithmsSolutions\\src\\me\\zonglun\\Graph\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, fileName);
        Components components1 = new Components(g1);
        System.out.println("test G1 in SparseGraph: " + components1.getCount());
        // g1.show();
        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, fileName);
        Components components2 = new Components(g2);
        System.out.println("test G1 in Dense Graph:" + components2.getCount());
        // g2.show();
        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        String  filename2 = "E:\\project\\java-Project\\AlgorithmsSolutions\\src\\me\\zonglun\\Graph\\testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename2);
        Components components3 = new Components(g3);
        System.out.println("test G2 in Sparse Graph:" + components3.getCount());
        // g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename2);
        System.out.println("test G2 in Dense Graph:");
        g4.show();
    }
}
