package com.xysfxy.priority;

/**
 * @author: 周宝辉
 * @date: 2020/7/22 12:06
 * @descripation:最大优先队列（依据最大堆实现的）
 */
public class MaxPriorityQueue<T extends Comparable> {
    private T[] item;
    private int N;

    public MaxPriorityQueue(int capacity){
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
     * 删除最大元素
     * @return
     */
    public T delMax(){
        T max = item[1];
        swap(1, N);
        item[N] = null;
        --N;
        sink(1);
        return max;
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
            if(less(k / 2, k)){
                swap(k / 2, k);
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
            int max = 2 * k;
            if(2 * k + 1 <= N){
                if(less(2 * k, 2 * k + 1)){
                    max = 2 * k + 1;
                }else{
                    max = 2 * k;
                }
            }
            if(!less(k, max)){
                break;
            }else{
                swap(k, max);
            }
            k = max;
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
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        queue.insert("H");
        while(!queue.isEmpty()){
            String s = queue.delMax();
            System.out.print(s + " ");
        }
    }
}
