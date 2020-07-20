package com.xysfxy.heap;

/**
 * @Auther: ÷‹±¶ª‘
 * @Date: 2020/7/20 18:00
 * @Description:∂—≈≈–Ú
 */
public class HeapSort<T extends Comparable<T>>{

    public static void sort(Comparable[] source){

    }

    private static void create(Comparable[] source, Comparable[] heap){
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = heap.length / 2; i > 0; i--) {
            sink(source, i, heap.length - 1);
        }
    }

    private static void sink(Comparable[] heap, int target, int range){
        for (int i = target; i >= range; i--) {

            while(2 * i <= heap.length){
                int max = 2 * i;
                if(less(heap, 2 * i, 2 * i + 1)){
                    max = 2 * i - 1;
                }else{
                    max = 2 * i;
                }
                swap(heap, i, max);

            }
        }
    }

    private static boolean less(Comparable[] source, int i, int j){
        return source[i].compareTo(source[j]) < 0;
    }

    private static void swap(Comparable[] source, int i, int j){
        Comparable temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}