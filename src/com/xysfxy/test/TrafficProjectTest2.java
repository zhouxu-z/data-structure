package com.xysfxy.test;

import com.xysfxy.graph.DepthFirstSearch;
import com.xysfxy.graph.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: 周宝辉
 * @date: 2020/7/23 23:02
 * @descripation:畅通工程测试（图的实现）
 */
public class TrafficProjectTest2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(TrafficProjectTest2.class.getClassLoader().getResourceAsStream("trafficProject.txt")));
        int totalNumber = Integer.parseInt(br.readLine());
        int roadNumber = Integer.parseInt(br.readLine());
        Graph graph = new Graph(totalNumber);
        for (int i = 0; i < roadNumber; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            graph.addEdge(p, q);
        }
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 9);
        System.out.println(dfs.isMarked(10));
        System.out.println(dfs.isMarked(8));
    }
}
