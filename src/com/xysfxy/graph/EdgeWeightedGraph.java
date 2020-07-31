package com.xysfxy.graph;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 16:36
 * @descripation:加权无向图的实现
 */
public class EdgeWeightedGraph {
    private int v;
    private int e;
    private ArrayDeque<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = new ArrayDeque[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayDeque<Edge>();
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.e++;
    }

    public ArrayDeque<Edge> adj(int v){
        return adj[v];
    }

    /**
     * 获取加权无向图的所有边
     * @return
     */
    public ArrayDeque<Edge> edges() {
        ArrayDeque<Edge> edges = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            for (Edge edge : adj(i)) {
                if(edge.other(i) < i){
                    edges.add(edge);
                }
            }
        }
        return edges;
    }
}
