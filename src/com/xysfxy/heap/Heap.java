package com.xysfxy.heap;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/20 16:20
 * @Description:����
 */
public class Heap<T extends Comparable> {
    private T[] item;
    private int N;

    public Heap(int capacity) {
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
        T max = item[1];
        swap(1, N);
        item[N] = null;
        --N;
        swim(1);
        return max;
    }

    /**
     * ʹ���³��㷨��ʹ������k����Ԫ�����ڶ��д���һ����ȷ��λ��
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
     * ����
     * @param t
     */
    public void insert(T t) {
        item[++N] = t;
        sink(N);
    }

    /**
     * ʹ���ϸ��㷨��ʹ������k����Ԫ�����ڶ��д���һ����ȷ��λ��
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