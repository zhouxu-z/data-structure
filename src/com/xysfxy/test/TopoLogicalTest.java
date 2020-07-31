package com.xysfxy.test;

import com.xysfxy.graph.Digraph;
import com.xysfxy.graph.TopoLogical;

import java.util.Stack;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 16:05
 * @descripation:
 */
public class TopoLogicalTest {
    public static void main(String[] args) {
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(1, 3);

        TopoLogical topoLogical = new TopoLogical(digraph);
        Stack<Integer> order = topoLogical.order();
        int size = order.size();
        for (int i = 0; i < size; i++) {
            System.out.println(order.pop());
        }
    }
}
