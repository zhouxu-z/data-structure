package com.xysfxy.graph;

/**
 * @author: 周宝辉
 * @date: 2020/7/30 15:34
 * @descripation:加权有向图边的表示
 */
public class DirectedEdge {
    /**
     * 有向边的起点
     */
    private int v;
    /**
     * 有向边的终点
     */
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    /**
     * 获取起点
     * @return
     */
    public int from(){
        return v;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    /**
     * 获取终点
     * @return
     */
    public int to(){
        return w;
    }


}
