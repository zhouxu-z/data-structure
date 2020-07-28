package com.xysfxy.graph;

import java.util.Queue;

/**
 * @author: 周宝辉
 * @date: 2020/7/25 15:32
 * @descripation:图的深度优先搜索
 */
public class DepthFirstSearch {
    /**
     * 索引代表顶点，值代表当前顶点是否已经被搜索过
     */
    private boolean[] marked;
    /**
     * 记录有多少个顶点与s顶点相通
     */
    private int count;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出图中s顶点的所有相通顶点
     * @param g
     * @param s
     */
    public DepthFirstSearch(Graph g, int s) {
        this.marked = new boolean[g.v()];
        this.count = 0;
            dfs(g, s);
    }

    /**
     * 判断w顶点与s顶点是否相通
     * @param w
     * @return
     */
    public boolean isMarked(int w) {
        return marked[w];
    }

    /**
     * 获取与s顶点相通的所有顶点的总数
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * @param g
     * @param v
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if(!marked[w]){
                dfs(g, w);
            }
        }
        count++;
    }
}
