package com.xysfxy.collection;

import java.util.Iterator;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/15 12:00
 * @Description:栈的实现
 */
public class Stack<T> implements Iterable<T> {
    private Node head;
    private int N;

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEampty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 入栈
     *
     * @return
     */
    public void pop(T t) {
        if (isEampty()) {
            Node node = new Node(t, null);
            head.setNext(node);
        } else {
            Node next = head.getNext();
            Node node = new Node(t, next);
            head.setNext(node);
            node.setNext(next);
        }
        N++;
    }

    /**
     * 出栈
     */
    public T push() {
        if (!isEampty()) {
            Node next = head.getNext();
            head.setNext(next.getNext());
            N--;
            return (T) next.getItem();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        private Node node;

        public MyIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.getNext() != null;
        }

        @Override
        public T next() {
            node = node.getNext();
            return (T)node.getItem();
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.pop("a");
        stack.pop("b");
        stack.pop("c");
        stack.pop("d");
        System.out.println("入栈");
        for(String s : stack){
            System.out.println(s);
        }

        System.out.println("出栈");
        stack.push();
        stack.push();
        stack.push();
        for(String s : stack){
            System.out.println(s);
        }

        System.out.println("是否为空：" + stack.isEampty());
        System.out.println("元素个数：" + stack.size());

    }
}