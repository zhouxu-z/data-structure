package com.xysfxy.graph;

/**
 * @author: 周宝辉
 * @date: 2020/7/29 16:24
 * @descripation:加权无向图边的表示
 */
public class Edge implements Comparable{
    /**
     * 顶点一
     */
    private int v;
    /**
     * 顶点二
     */
    private int w;
    /**
     * 当前边的权重值
     */
    private double weight;

    /**
     * @param v
     * @param w
     * @param weight
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     * @return
     */
    public double weight(){
        return weight;
    }

    /**
     * 获取边的一个点
     * @return
     */
    public int either(){
        return v;
    }

    /**
     * 获取边除了vertex的另一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex){
        if(vertex == v){
            return w;
        }
        if(vertex == w){
            return v;
        }
        return -1;
    }

    @Override
    public int compareTo(Object o) {
        int cmp;
        Edge edge = (Edge) o;
        if(this.weight > edge.weight()){
            cmp = 1;
        } else if(this.weight < edge.weight()){
            cmp = -1;
        } else {
            cmp = 0;
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
