package com.xysfxy.test;

import com.xysfxy.graph.DepthFirstSearch;
import com.xysfxy.graph.Graph;

/**
 * @author: 周宝辉
 * @date: 2020/7/25 16:42
 * @descripation:
 */
public class DepthFirstSearchTest {

    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        DepthFirstSearch search = new DepthFirstSearch(graph, 0);
        System.out.println(search.count());

        System.out.println(search.isMarked(5));
        System.out.println(search.isMarked(7));
    }
}
