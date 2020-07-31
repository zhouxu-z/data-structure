package com.xysfxy.graph;


import java.util.Stack;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 15:55
 * @descripation:拓扑排序
 */
public class TopoLogical {
    /**
     * 顶点的拓扑排序
     */
    private Stack<Integer> order;

    /**
     * 构造拓扑排序对象
     * @param g
     */
    public TopoLogical(Digraph g) {
        DirectedCycle cycle = new DirectedCycle(g);
        if(!cycle.isHasCycle()){
            DepthFirstOrder order = new DepthFirstOrder(g);
            this.order = order.reversePost();
        }
    }

    /**
     * 判断图中是否有环
     * @return
     */
    public boolean isCycle() {
        return order == null;
    }

    /**
     * 获取拓扑排序的所有顶点
     * @return
     */
    public Stack<Integer> order(){
        return order;
    }
}
