package com.xysfxy.collection;


import java.util.Iterator;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/15 15:16
 * @Description:队列的实现
 */
public class Queue<T> implements Iterable<T> {
    private Node head;
    private Node last;
    private int N;

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEampty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 取出元素
     *
     * @return
     */
    public T dequeue() {
        if (!isEampty()) {
            Node node = head.getNext();
            head.setNext(node.getNext());
            N--;
            if(isEampty()){
                last = null;
            }
            return (T) node.getItem();
        }
        return null;
    }

    /**
     * 插入元素
     *
     * @param t
     */
    public void enqueue(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.setNext(last);
        } else {
            Node node = new Node(t, null);
            last.setNext(node);
            last = node;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node n;

        public MyIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.getNext() != null;
        }

        @Override
        public T next() {
            n = n.getNext();
            return (T) n.getItem();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("插入元素");
        for (int i : queue) {
            System.out.println(i);
        }

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("删除元素");
        for (int i : queue) {
            System.out.println(i);
        }
        System.out.println(queue.isEampty());
        System.out.println(queue.size());
    }
}