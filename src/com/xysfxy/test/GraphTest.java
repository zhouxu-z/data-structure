package com.xysfxy.test;

import com.xysfxy.graph.Graph;

/**
 * @author: 周宝辉
 * @date: 2020/7/25 15:29
 * @descripation:无向图测试
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        System.out.println(graph.e());

        graph.addEdge(0, 7);
        graph.addEdge(0, 3);
        System.out.println(graph.e());
    }
}
