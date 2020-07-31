package com.xysfxy.graph;

import com.xysfxy.priority.IndexMinPriorityQueue;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/30 16:06
 * @descripation:最短路径树
 */
public class DijkstraSP {
    /**
     * 索引代表值，值表示从顶点s到当前顶点的最短路径上的最后一条边
     */
    private DirectedEdge[] edgeTo;
    /**
     * 索引代表顶点，值表示顶点s到当前顶点的虽短路径的总权重
     */
    private double[] distTo;
    /**
     * 存放舒总顶点与非树中顶点之间的有效横切边
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 构造一副加权有向图，创建一个最短路径树对象
     * @param g
     * @param s
     */
    public DijkstraSP(EdgeWeightedDigraph g, int s){
        this.edgeTo = new DirectedEdge[g.v()];
        this.distTo = new double[g.v()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        this.pq = new IndexMinPriorityQueue<>(g.v());
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while(!pq.isEmpty()){
            relax(g, pq.delMin());
        }
    }

    /**
     * 获取从顶点s到顶点v的最短路径的总权重
     * @param v
     * @return
     */
    public double distTo(int v){
        return distTo[v];
    }

    /**
     * 判断从顶点s到顶点v是都可达
     * @param v
     * @return
     */
    public boolean hasPathTo(int v){
        return distTo[v] < Double.MAX_VALUE;
    }

    /**
     * 查询从顶点s到当前顶点的最短路径中所有的边
     * @param v
     * @return
     */
    public ArrayDeque<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) {
            return null;
        }
        ArrayDeque<DirectedEdge> allEdges = new ArrayDeque<>();
        while(true) {
            DirectedEdge edge = edgeTo[v];
            if (edge == null) {
                break;
            }
            allEdges.add(edge);
            v = edge.from();
        }
        return allEdges;
    }

    /**
     * 松弛图中的顶点
     * @param g
     * @param v
     */
    private void relax(EdgeWeightedDigraph g, int v){
        for (DirectedEdge edge : g.adj(v)) {
            int w = edge.to();
            if(distTo(v) +  edge.weight() < distTo(w)){
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
            }
            if(pq.contains(w)){
                pq.changeItem(w, distTo(w));
            } else{
                pq.insert(w, distTo(w));
            }
        }
    }
}
