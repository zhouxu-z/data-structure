package com.xysfxy.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: 周宝辉
 * @date: 2020/7/25 14:35
 * @descripation:图的实现
 */
public class Graph {
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
    private Queue<Integer>[] adj;

    /**
     * 构造方法，创建一个包含顶点但不包含边的图
     * @param v
     */
    public Graph(int v){
        this.v = v;
        this.e = 0;
        this.adj = new Queue[v];
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
     * 向图中国插入一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        if(v < adj.length && w < adj.length){
            adj[v].add(w);
            adj[w].add(v);
            e++;
        }

    }

    /**
     * 获取和顶点v相邻的所有顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v){
       if(v < adj.length){
           return adj[v];
       }
       return null;
    }
}
