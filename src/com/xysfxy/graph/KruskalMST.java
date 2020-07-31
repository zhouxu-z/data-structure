package com.xysfxy.graph;

import com.xysfxy.priority.MinPriorityQueue;
import com.xysfxy.tree.UfTreeWeighted;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/30 12:27
 * @descripation:
 */
public class KruskalMST {
    /**
     * 保存最小生成树的所有边
     */
    private ArrayDeque<Edge> mst;
    private UfTreeWeighted uf;
    /**
     * 存储图中所有的边，使用最小优先队列按权重排序
     */
    private MinPriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph g){
        this.mst = new ArrayDeque<>();
        this.uf = new UfTreeWeighted(g.v());
        this.pq = new MinPriorityQueue<>(g.e() + 1);
        for (Edge edge : g.edges()) {
            pq.insert(edge);
        }
        while(!pq.isEmpty() && mst.size() < g.v()){
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if(!uf.connected(v, w)){
                uf.union(v, w);
                mst.add(edge);
            }
        }
    }

    public ArrayDeque<Edge> edges(){
        return mst;
    }
}
