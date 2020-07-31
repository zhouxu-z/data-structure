package com.xysfxy.graph;

import java.util.Stack;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 13:42
 * @descripation:基于深度优先的顶点排序
 */
public class DepthFirstOrder {
    /**
     * 索引代表顶点，值代表当前顶点是否已经被搜索过
     */
    private boolean[] marked;
    /**
     * 使用栈，存储顶点序列
     */
    private Stack<Integer> reversePost;

    /**
     * 创建一个顶点序列排序对象，生成顶点线性序列
     * @param g
     */
    public DepthFirstOrder(Digraph g){
        this.marked = new boolean[g.v()];
        this.reversePost = new Stack<>();
        for (int i = 0; i < g.v(); i++) {
            if(!marked[i]){
                dfs(g, i);
            }
        }
    }

    /**
     * 获取顶点线性序列
     * @return
     */
    public Stack<Integer> reversePost(){
        return reversePost;
    }

    /**
     * 基于深度优先搜索，生成顶点线性序列
     * @param g
     * @param v
     */
    private void dfs(Digraph g, int v){
        marked[v] = true;
        for (Integer w : g.adj(v)) {
            if(!marked[w]){
                dfs(g, w);
            }
        }
        reversePost.push(v);
    }
}
