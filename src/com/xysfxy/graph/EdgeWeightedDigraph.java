package com.xysfxy.graph;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 16:36
 * @descripation:加权有向图的实现
 */
public class EdgeWeightedDigraph {
    private int v;
    private int e;
    private ArrayDeque<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = new ArrayDeque[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayDeque<DirectedEdge>();
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj(v).add(e);
        this.e++;
    }

    public ArrayDeque<DirectedEdge> adj(int v){
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     * @return
     */
    public ArrayDeque<DirectedEdge> edges() {
        ArrayDeque<DirectedEdge> allEdge = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            for (DirectedEdge edge : adj(v)) {
                allEdge.add(edge);
            }
        }
        return allEdge;
    }
}
