package com.xysfxy.priority;

import java.util.Arrays;

/**
 * @author: 周宝辉
 * @date: 2020/7/22 16:10
 * @descripation:最小索引优先队列
 */
public class IndexMinPriorityQueue<T extends Comparable> {
    //用来存储元素的数组
    private T[] item;
    //保存每个元素在item数组中的索引，需要堆有序
    private int[] pq;
    //保存pq的逆序，pq的索引所谓值，pq的值作为索引
    private int[] qp;
    //元素的个数
    private int N;

    public IndexMinPriorityQueue(int capacity){
        this.item = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;
        //默认情况下，队列中没有任何元素，让qp中的每一个元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    /**
     * 判断元素的大小关系
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j){
        return item[pq[i]].compareTo(item[pq[j]]) < 0;
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void swap(int i, int j){
        int temp1 = pq[i];
        pq[i] = pq[j];
        pq[j] = temp1;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 删除最小元素，并返回其对应的索引
     * @return
     */
    public int delMin(){
        int minIndex = pq[1];
        swap(1, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        item[minIndex] = null;
        --N;
        sink(1);
        return minIndex;
    }

    /**
     * 往队列中插入一个元素，并关联索引
     * @param i
     * @param t
     */
    public void insert(int i, T t){
        if(contains(i)){
            return;
        }
        ++N;
        item[i] = t;
        pq[N] = i;
        qp[i] = N;
        swin(N);
    }

    /**
     * 上浮
     * @param k
     */
    private void swin(int k){
        while(k > 1){
            if(less(k, k / 2)){
                swap(k, k / 2);
            }
            k = k / 2;
        }
    }

    /**
     * 下沉
     * @param k
     */
    private void sink(int k){
        while(2 * k <= N){
            int min = 2 * k;
            if(2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            }
            if(less(k, min)){
                break;
            }else{
                swap(min, k);
            }
            k = min;
        }
    }

    /**
     * 返回队列中元素的个数
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 判断k索引对应的元素是否存在
     * @param k
     * @return
     */
    public boolean contains(int k){
        System.out.println(Arrays.toString(qp));
        return qp[k] != -1;
    }

    /**
     * 改变索引i对应的元素
     * @param i
     * @param t
     */
    public void changeItem(int i, T t){
        item[i] = t;
        int k = qp[i];
        swin(k);
        sink(k);
    }

    /**
     * 返回最小元素关联的索引
     * @return
     */
    public int minIndex(){
        return pq[1];
    }

    /**
     * 删除索引i关联的元素
     * @param i
     */
    public void delete(int i){
        int k = qp[i];
        swap(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        item[k] = null;
        --N;
        swin(k);
        sink(k);
    }

    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<String>(10);
        queue.insert(0, "A");
        queue.insert(1, "C");
        queue.insert(2, "F");
        queue.changeItem(2, "B");
        while(!queue.isEmpty()){
            int i = queue.delMin();
            System.out.print(i + " ");
        }
    }
}
