package com.xysfxy.tree;

/**
 * @author: 周宝辉
 * @date: 2020/7/23 17:46
 * @descripation:并查集
 */
public class Uf {
    /**
     * 记录结点元素和元素所在分组的标识记录
     */
    private int[] eleAndGroup;
    /**
     *记录并查集中数据分组的个数
     */
    private int count;

    public Uf(int count){
        this.count = count;
        eleAndGroup = new int[count];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
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
        return eleAndGroup[p];
    }

    /**
     * 把p元素所在的分组和q元素所在的分组合并
     * @param p
     * @param q
     */
    public void union(int p, int q){
        if(connected(p, q)){
            return;
        }
        int pp = find(p);
        int qq = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if(eleAndGroup[i] == pp){
                eleAndGroup[i] = qq;
            }
        }
        this.count--;
    }
}
