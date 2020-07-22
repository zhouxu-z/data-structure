package com.xysfxy.heap;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/20 16:20
 * @Description:最大堆
 */
public class Heap<T extends Comparable> {
    private T[] item;
    private int N;

    public Heap(int capacity) {
        this.item = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 判断堆中索引i的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return item[i].compareTo(item[j]) < 0;
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    /**
     * 删除最大元素并返回
     * @return
     */
    public T delMax() {
        T max = item[1];
        swap(1, N);
        item[N] = null;
        --N;
        swim(1);
        return max;
    }

    /**
     * 使用下沉算法，使得索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k) {
        while (2 * k <= N) {
            int maxIndex = 2 * k;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    maxIndex = 2 * k + 1;
                } else {
                    maxIndex = 2 * k;
                }
            }
            if (!less(k, maxIndex)) {
                break;
            } else {
                swap(k, maxIndex);
            }
            k = maxIndex;
        }
    }

    /**
     * 插入
     * @param t
     */
    public void insert(T t) {
        item[++N] = t;
        sink(N);
    }

    /**
     * 使用上浮算法，使得索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void sink(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                swap(k, k / 2);
            }
            k = k / 2;
        }
    }

    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        String result = null;
        while ((result = heap.delMax()) != null) {
            System.out.print(result + " ");
        }
    }
}