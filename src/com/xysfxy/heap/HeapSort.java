package com.xysfxy.heap;

import java.util.Arrays;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/20 18:00
 * @Description:堆排序
 */
public class HeapSort<T extends Comparable>{
    /**
     * 排序
     * @param source
     */
    public static void sort(Comparable[] source) {
        Comparable[] heap = new Comparable[source.length + 1];
        create(source, heap);
        int N = heap.length - 1;
        while(N != 1){
            swap(heap, 1, N);
            N--;
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    /**
     * 根据传入的数组构建堆数组
     * @param source
     * @param heap
     */
    private static void create(Comparable[] source, Comparable[] heap) {
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = heap.length / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    /**
     * 下沉
     * @param heap
     * @param target
     * @param range
     */
    private static void sink(Comparable[] heap, int target, int range) {
        while(2 * target <= range){
            int max = 2 * target;
            if(2 * target + 1 <= range) {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            }
            if(!less(heap, target, max)){
                break;
            }else {
                swap(heap, max, target);
            }
            target = max;
        }
    }

    /**
     * 判断关系
     * @param source
     * @param i
     * @param j
     * @return
     */
    private static boolean less(Comparable[] source, int i, int j) {
        return source[i].compareTo(source[j]) < 0;
    }

    /**
     * 交换
     * @param source
     * @param i
     * @param j
     */
    private static void swap(Comparable[] source, int i, int j) {
        Comparable temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 1, 8, 9, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}