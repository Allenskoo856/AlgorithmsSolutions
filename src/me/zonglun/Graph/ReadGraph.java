/*
 * Copyright (C), 2015-2017
 * FileName: ReadGraph
 * Author:   Administrator
 * Date:     2017/11/13 0013 20:53
 * Description: ReadGraph     
 */

package me.zonglun.Graph;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈ReadGraph 〉
 *
 * @author Administrator
 * @create 2017/11/13 0013
 * @since 1.0.0
 */
public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph, String filename){

        readFile(filename);

        try {
            int V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(v, w);
            }
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private void readFile(String filename){
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else
                throw new IllegalArgumentException(filename + "doesn't exist.");
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Could not open " + filename, ioe);
        }
    }
}
