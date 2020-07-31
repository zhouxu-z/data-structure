package com.xysfxy.priority;

/**
 * @author: 周宝辉
 * @date: 2020/7/22 12:06
 * @descripation:最小优先队列（依据最小堆实现的）
 */
public class MinPriorityQueue<T extends Comparable> {
    private T[] item;
    private int N;

    public MinPriorityQueue(int capacity){
        this.item = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 判断元素大小
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j){
        return item[i].compareTo(item[j]) < 0;
    }

    /**
     * 交换元素
     * @param i
     * @param j
     */
    private void swap(int i, int j){
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    /**
     * 删除最小元素
     * @return
     */
    public T delMin(){
        T min = item[1];
        swap(1, N);
        item[N] = null;
        --N;
        sink(1);
        return min;
    }

    /**
     * 插入元素
     * @param t
     */
    public void insert(T t){
        item[++N] = t;
        swim(N);
    }

    /**
     * 上浮，使得元素处于一个正确的位置
     * @param k
     */
    private void swim(int k){
        while(k > 1){
            if(less(k, k / 2)){
                swap(k, k / 2);
            }
            k = k / 2;
        }
    }

    /**
     * 下沉，使得元素处于一个正确的位置
     * @param k
     */
    private void sink(int k){
        while(2 * k <= N){
            int min = 2 * k;
            if(2 * k + 1 <= N){
                if(less(2 * k, 2 * k + 1)){
                    min = 2 * k;
                }else{
                    min = 2 * k + 1;
                }
            }
            if(!less(min, k)){
                break;
            }else{
                swap(k, min);
            }
            k = min;
        }
    }

    /**
     * 获取元素的个数
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

    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        queue.insert("H");
        while(!queue.isEmpty()){
            String s = queue.delMin();
            System.out.print(s + " ");
        }
    }
}
