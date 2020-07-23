package com.xysfxy.heap;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/20 16:20
 * @Description:��С��
 */
public class MinHeap<T extends Comparable> {
    private T[] item;
    private int N;

    public MinHeap(int capacity) {
        this.item = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * �ж϶�������i��Ԫ���Ƿ�С������j����Ԫ��
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return item[i].compareTo(item[j]) < 0;
    }

    /**
     * ����
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    /**
     * ɾ�����Ԫ�ز�����
     * @return
     */
    public T delMax() {
        T min = item[1];
        swap(1, N);
        item[N] = null;
        --N;
        sink(1);
        return min;
    }

    /**
     * ʹ���³��㷨��ʹ������k����Ԫ�����ڶ��д���һ����ȷ��λ��
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int min = 2 * k;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            }
            if (!less(min, k)) {
                break;
            } else {
                swap(k, min);
            }
            k = min;
        }
    }

    /**
     * ����
     * @param t
     */
    public void insert(T t) {
        item[++N] = t;
        swim(N);
    }

    /**
     * ʹ���ϸ��㷨��ʹ������k����Ԫ�����ڶ��д���һ����ȷ��λ��
     * @param k
     */
    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                swap(k, k / 2);
            }
            k = k / 2;
        }
    }

    public static void main(String[] args) {
        MinHeap<String> heap = new MinHeap<>(10);
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