package com.xysfxy.graph;

import com.xysfxy.collection.Queue;

import java.util.ArrayDeque;

/**
 * @author: 周宝辉
 * @date: 2020/7/25 15:32
 * @descripation:图的深度优先搜索
 */
public class BreadthFirstSearch {
    /**
     * 索引代表顶点，值代表当前顶点是否已经被搜索过
     */
    private boolean[] marked;
    /**
     * 记录有多少个顶点与s顶点相通
     */
    private int count;
    /**
     * 用来存储待搜索的邻接表的点
     */
    private ArrayDeque<Integer> waitSearch;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出图中s顶点的所有相通顶点
     * @param g
     * @param s
     */
    public BreadthFirstSearch(Graph g, int s) {
        this.marked = new boolean[g.v()];
        this.count = 0;
        this.waitSearch = new ArrayDeque<>();
        bfs(g, s);
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
     * 使用广度优先搜索找出图中v顶点的所有相邻顶点
     * @param g
     * @param v
     */
    private void bfs(Graph g, int v) {
        marked[v] = true;
        waitSearch.add(v);
        while (!waitSearch.isEmpty()){
            Integer i = waitSearch.removeFirst();
            for (Integer w : g.adj(i)) {
                if(!marked[w]){
                    bfs(g, w);
                }
            }
        }
        count++;
    }
}
