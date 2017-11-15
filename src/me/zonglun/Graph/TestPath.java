/*
 * Copyright (C), 2015-2017
 * FileName: TestPath
 * Author:   Administrator
 * Date:     2017/11/15 0015 10:35
 * Description:     
 */

package me.zonglun.Graph;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2017/11/15 0015
 * @since 1.0.0
 */
public class TestPath {
    public static void main(String[] args) {
        String filename = "E:\\project\\java-Project\\AlgorithmsSolutions\\src\\me\\zonglun\\Graph\\testG.txt";
        SparseGraph g  = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g, 0);
        System.out.println("DFS for path from 0 to 6: ");
        path.showPath(6);
        ShortestPath spath = new ShortestPath(g,0);
        System.out.println("BFS for path from 0 to 6: ");
        spath.showPath(6);
    }
}
