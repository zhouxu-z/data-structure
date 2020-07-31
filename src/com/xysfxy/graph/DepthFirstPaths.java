package com.xysfxy.graph;

import java.util.Stack;

/**
 * @author: 周宝辉
 * @date: 2020/7/28 13:17
 * @descripation:无向图的路径查找
 */
public class DepthFirstPaths {
    /**
     * 索引代表顶点，值表示当前顶点是否已经搜索
     */
    private boolean[] marked;
    /**
     * 起点
     */
    private int s;
    /**
     * 索引代表顶点，值表示从起点s到当前顶点路径上的最后一个顶点
     */
    private int[] edgeTo;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出图中起点为s的所有路径
     * @param g
     * @param s
     */
    public DepthFirstPaths(Graph g, int s){
        this.marked = new boolean[g.v()];
        this.s = s;
        this.edgeTo = new int[g.v()];
        dfs(g, s);
    }

    /**
     * 判断v顶点与s顶点是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    /**
     * 找出从起点s到顶点v的路径（就是该路径经过的顶点）
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v){
        if(hasPathTo(v)){
            Stack<Integer> path = new Stack<>();
            for (int i = v; i != s ; i = edgeTo[i]) {
                path.push(i);
            }
            path.push(s);
            return path;
        }
        return null;
    }


    /**
     * 使用深度优先搜索找出图中v顶点的所有相邻顶点
     * @param g
     * @param v
     */
    private void dfs(Graph g, int v){
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
}
