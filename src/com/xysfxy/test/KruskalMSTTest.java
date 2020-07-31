package com.xysfxy.test;

import com.xysfxy.graph.Edge;
import com.xysfxy.graph.EdgeWeightedGraph;
import com.xysfxy.graph.KruskalMST;
import com.xysfxy.graph.PrimMST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;


/**
 * @author: 周宝辉
 * @date: 2020/7/29 22:40
 * @descripation:
 */
public class KruskalMSTTest {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("primFile.txt"));
        int n = Integer.parseInt(br.readLine());
        EdgeWeightedGraph graph = new EdgeWeightedGraph(n);
        int row = Integer.parseInt(br.readLine());
        for (int i = 0; i < row; i++) {
            String r = br.readLine();
            String[] split = r.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);
            Edge edge = new Edge(v, w, weight);
            graph.addEdge(edge);
        }
        KruskalMST primMST = new KruskalMST(graph);
        ArrayDeque<Edge> edges = primMST.edges();
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }
}
