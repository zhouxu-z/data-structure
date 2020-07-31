package com.xysfxy.graph;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/28 14:27
 * @descripation:有向图
 */
public class Digraph {
    /**
     * 记录顶点数量
     */
    private int v;
    /**
     * 记录边的数量
     */
    private int e;
    /**
     * 邻接表
     */
    private ArrayDeque<Integer>[] adj;

    /**
     * 创建一个包含v个顶点但不包含边的有向图
     * @param v
     */
    public Digraph(int v){
        this.v = v;
        this.e = 0;
        adj = new ArrayDeque[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayDeque<Integer>();
        }
    }

    /**
     * 获取图中顶点的数量
     * @return
     */
    public int v(){
        return v;
    }

    /**
     * 获取图中边的数量
     * @return
     */
    public int e(){
        return e;
    }

    /**
     * 向图中添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        //只需要让w顶点出现在v顶点的邻接表中即可
        adj(v).add(w);
        e++;
    }

    /**
     * 获取v顶点的邻接表
     * @param v
     * @return
     */
    public ArrayDeque<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 改图的反向图
     * @return
     */
    private Digraph reverse(){
        //创建新图
        Digraph reverseDigraph = new Digraph(v);
        //遍历图
        for (int i = 0; i < v; i++) {
            //遍历顶点的邻接表
            for (Integer w : adj(v)) {
                addEdge(w, i);
            }
        }
        return reverseDigraph;
    }
}
