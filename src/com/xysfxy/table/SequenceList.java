package com.xysfxy.table;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/14 15:43
 * @Description:顺序表的实现
 */
public class SequenceList<T> implements Iterable<T>{
    private T[] eles;//存储元素的数组
    private int N;//记录元素的个数

    public SequenceList(int capacity) {
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    public void clear() {
        for (int i = 0; i < N; i++) {
            eles[i] = null;
        }
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        return eles[i];
    }

    public void insert(int i, T t) {
        if(N == eles.length){
            resrize(2 * N);
        }
        for (int j = N; j > i; j--) {
            eles[j] = eles[j - 1];
        }
        eles[i] = t;
        N++;
    }

    public void insert(T t) {
        if(N == eles.length){
            resrize(2 * N);
        }
        eles[N++] = t;
    }

    public T remove(int i) {
        System.out.println("长度" + eles.length);
        T current = eles[i];
        for(int j = i; j < N; j++){
            eles[j] = eles[j + 1];
        }
        N--;
        if(N < eles.length / 4){
            resrize(eles.length / 2);
        }
        return current;
    }

    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 重置数组大小
     * @param newSize
     */
    public void resrize(int newSize){
        T[] newArr = (T[])new Object[newSize];
        for(int i = 0; i < N; i++){
            newArr[i] = eles[i];
        }
        eles = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();

    }

    class MyIterator implements Iterator<T>{
        private int curror;
        public MyIterator(){
            this.curror = 0;
        }

        @Override
        public boolean hasNext() {
            return curror < N;
        }

        @Override
        public T next() {
            return eles[curror++];
        }
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "eles=" + Arrays.toString(eles) +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {
        SequenceList<Integer> sl = new SequenceList<>(3);
        sl.insert(1);
        sl.insert(3);
        sl.insert(4);
        sl.insert(1,2 );
        for(Integer t : sl){
            System.out.println(t);
        }
        System.out.println("-------------------------------");
        System.out.println(sl);
        boolean empty = sl.isEmpty();
        System.out.println(empty);
        int length = sl.length();
        System.out.println(length);
        Integer integer = sl.get(0);
        System.out.println(integer);
        int i = sl.indexOf(4);
        System.out.println(i);
        Integer remove = sl.remove(2);
        System.out.println(remove);
        System.out.println(sl);
        sl.clear();
    }
}