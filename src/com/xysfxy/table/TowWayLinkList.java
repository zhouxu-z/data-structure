package com.xysfxy.table;

import java.util.Iterator;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/14 20:38
 * @Description:双向链表
 */
public class TowWayLinkList<T> implements Iterable<T> {
    private Node frist;//记录首结点
    private Node last;//记录尾结点
    private int N;//记录元素的个数

    public TowWayLinkList() {
        this.frist = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    private class Node<T> {
        T item;//存放数据
        Node pre;//指向上一个结点
        Node next;//指向下一个结点

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public void clear() {
        this.frist.next = null;
        this.last = null;
        N = 0;
    }

    public boolean isEampty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        Node n = frist;
        for (int j = 0; j <= i; j++) {
            n = n.next;
        }
        return (T) n.item;
    }

    public void insert(T t) {
        if (isEampty()) {
            //链表为空
            Node node = new Node(t, frist, null);
            last = node;
            frist.next = last;
        } else {
            //链表不为空
            Node node = new Node(t, last, null);
            last.next = node;
            last = node;
        }
        N++;
    }

    public void insert(int i, T t) {
        Node n = frist;
        for (int j = 0; j <= i - 1; j++) {
            n = n.next;
        }
        Node nload = n.next;
        Node newNode = new Node(t, n, nload);
        n.next = newNode;
        nload.pre = newNode;
        N++;
    }

    public T remove(int i) {
        Node n = frist;
        for (int j = 0; j <= i - 1; j++) {
            n = n.next;
        }
        Node nI = n.next;
        Node nload = nI.next;
        n.next = nload;
        nload.pre = n;
        N--;
        return (T) nI.item;
    }

    public int indexOf(T t) {
        Node n = frist;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T getFrist() {
        if (isEampty()) {
            return null;
        }
        return (T) frist.next.item;
    }

    public T getLast() {
        if (isEampty()) {
            return null;
        }
        return (T) last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node n;

        public MyIterator() {
            this.n = frist;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return (T) n.item;
        }
    }

    public static void main(String[] args) {
        TowWayLinkList<Integer> tl = new TowWayLinkList<>();
        tl.insert(1);
        tl.insert(2);
        tl.insert(4);
        tl.insert(5);
        for(Integer i : tl){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(tl.indexOf(5));
        System.out.println("第一个元素" + tl.getFrist());
        System.out.println("最后一个元素" + tl.getLast());
        System.out.println();

        tl.insert(2, 3);
        for(Integer i : tl){
            System.out.print(i + " ");
        }
        System.out.println();

        boolean eampty = tl.isEampty();
        int length = tl.length();
        Integer integer = tl.get(2);
        System.out.println(eampty + " " + length + " " + integer);

        Integer remove = tl.remove(2);
        System.out.println(remove);
        for(Integer i : tl){
            System.out.print(i + " ");
        }
        System.out.println();
        tl.clear();
        System.out.println(tl.length());
    }
}