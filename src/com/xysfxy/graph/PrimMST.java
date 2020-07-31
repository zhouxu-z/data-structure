package com.xysfxy.graph;

import com.xysfxy.priority.IndexMinPriorityQueue;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 20:49
 * @descripation:最小生成树
 */
public class PrimMST {
    /**
     * 索引代表顶点，值表示当前顶点和最小生成树之间的最短边
     */
    private Edge[] edgeTo;
    /**
     * 索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
     */
    private double[] distTo;
    /**
     * 索引代表顶点，如果当前顶点已经在树中，则为true，否则为false
     */
    private boolean[] marked;
    /**
     * 存放树中顶点与非树中顶点之间的有效横切边
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * 构造一副加权无向图，创建最小生成树计算对象
     * @param g
     */
    public PrimMST(EdgeWeightedGraph g){
        this.edgeTo = new Edge[g.v()];
        this.distTo = new double[g.v()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        this.marked = new boolean[g.v()];
        pq = new IndexMinPriorityQueue<Double>(g.v());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while(!pq.isEmpty()){
            visit(g, pq.delMin());
        }
    }

    /**
     * 获取最小生成树的所有边
     * @return
     */
    public ArrayDeque<Edge> edges(){
        ArrayDeque<Edge> edges = new ArrayDeque<>();
        for (Edge edge : edgeTo) {
            if(edge != null){
                edges.add(edge);
            }
        }
        return edges;
    }

    /**
     * 将顶点v添加到最小生成树中，并且更新数据
     * @param g
     * @param v
     */
    private void visit(EdgeWeightedGraph g, int v){
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if(marked[w]){
                continue;
            }
            if(e.weight() < distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if(pq.contains(w)){
                    pq.changeItem(w, e.weight());
                } else{
                    pq.insert(w, e.weight());
                }
            }
        }
    }
}
