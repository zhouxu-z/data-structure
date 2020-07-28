package com.xysfxy.tree;

/**
 * @author: 周宝辉
 * @date: 2020/7/23 17:46
 * @descripation:优化后的并查集
 */
public class UfTreeWeighted {
    /**
     * 记录结点元素和元素所在分组的标识记录
     */
    private int[] eleAndGroup;
    /**
     *记录并查集中数据分组的个数
     */
    private int count;

    /**
     * 存储每个根结点对应的树中元素的个数
     */
    private int[] sz;

    public UfTreeWeighted(int count){
        this.count = count;
        eleAndGroup = new int[count];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        this.sz = new int[count];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    /**
     * 获取当前并查集中数据有多少个分组
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 判断当前并查集中数据p和数据q是否在同一个组
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 元素p所在分组标识
     * @param p
     * @return
     */
    public int find(int p){
        while(true){
            if(p > eleAndGroup.length - 1){
                System.out.println("超过了元素的个数");
                return -1;
            }
            if(p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }

    /**
     * 把p元素所在的分组和q元素所在的分组合并
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == -1 || qRoot == -1){
            return;
        }
        if(pRoot == qRoot){
            return;
        }

        if(sz[pRoot] < sz[qRoot]){
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] += pRoot;
        } else {
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += qRoot;
        }
        count--;
    }
}
