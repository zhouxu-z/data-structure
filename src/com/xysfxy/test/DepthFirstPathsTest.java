package com.xysfxy.test;
import com.xysfxy.graph.DepthFirstPaths;
import com.xysfxy.graph.Graph;

import java.util.Stack;

/**
 * @author: 周宝辉
 * @date: 2020/7/25 16:42
 * @descripation:
 */
public class DepthFirstPathsTest {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);

        DepthFirstPaths path = new DepthFirstPaths(graph, 0);
        Stack<Integer> stack = path.pathTo(4);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
