package com.xysfxy.graph;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 12:49
 * @descripation:检测有向图中是否有环
 */
public class DirectedCycle {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 记录图中是否有环
     */
    private boolean hasCycle;
    /**
     * 索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的路上
     */
    private boolean[] onStack;

    /**
     * 创建一个检测环对象，检测图中是否有环
     * @param g
     */
    public DirectedCycle(Digraph g){
        this.marked = new boolean[g.v()];
        this.hasCycle = false;
        this.onStack = new boolean[g.v()];
        //找到图中每一个顶点作为入口检测是否有环
        for (int i = 0; i < g.v(); i++) {
            if(!marked[i]){
                dfs(g, i);
            }
        }
    }

    /**
     * 判断图中是否有环
     * @return
     */
    public boolean isHasCycle(){
        return hasCycle;
    }

    /**
     * 基于深度优先搜索，检测图中是否有环
     * @param g
     * @param v
     */
    private void dfs(Digraph g, int v){
        marked[v] = true;
        onStack[v] = true;
        for (Integer w : g.adj(v)) {
            if(!marked[w]){
                dfs(g, w);
            }
            if(onStack[w]){
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
    }
}
