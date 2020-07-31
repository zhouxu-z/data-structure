package com.xysfxy.test;

import com.xysfxy.graph.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/30 17:07
 * @descripation:
 */
public class DijkstraSPTest {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("DijkstraSPFile.txt"));
        int n = Integer.parseInt(br.readLine());
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(n);
        int row = Integer.parseInt(br.readLine());
        for (int i = 0; i < row; i++) {
            String r = br.readLine();
            String[] split = r.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            double weight = Double.parseDouble(split[2]);
            DirectedEdge edge = new DirectedEdge(v, w, weight);
            digraph.addEdge(edge);
        }

        DijkstraSP sp = new DijkstraSP(digraph, 0);
//        ArrayDeque<DirectedEdge> deque = sp.pathTo(6);
//        for (DirectedEdge edge : deque) {
//            System.out.println(edge);
//        }


    }


}
