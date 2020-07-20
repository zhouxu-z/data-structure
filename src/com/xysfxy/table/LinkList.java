package com.xysfxy.table;

import com.xysfxy.collection.Node;

import java.util.Iterator;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/14 18:07
 * @Description:链表（单向链表）
 */
public class LinkList<T> implements Iterable<T>{
    private Node head;//记录首结点
    private int N;//记录链表的长度

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        head.setNext(null);
        N = 0;
    }

    public boolean isEampty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        Node n = head;
        for (int j = 0; j <= i; j++) {
            n = n.getNext();
        }
        return (T) n.getItem();
    }

    public void insert(T t) {
        Node n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        Node node = new Node(t, null);
        n.setNext(node);
        N++;
    }

    public void insert(int i, T t) {
        Node n = head;
        for (int j = 0; j <= i - 1; j++) {
            n = n.getNext();
        }
        Node node = new Node(t, n.getNext());
        n.setNext(node);
        N++;
    }

    public T remove(int i) {
        Node n = head;
        for (int j = 0; j <= i - 1; j++) {
            n = n.getNext();
        }
        Node next = n.getNext();
        Node nextNext = next.getNext();
        n.setNext(nextNext);
        N--;
        return (T) next.getItem();
    }

    public int indexOf(T t) {
        Node n = head;
        for (int j = 0; n.getNext() != null; j++) {
            n = n.getNext();
            if(n.getItem().equals(t)){
                return j;
            }
        }
        return -1;
    }

    /**
     * 反转链表
     */
    public void reverse(){
        if(isEampty()){
            return;
        }
        reverse(head.getNext());
    }

    /**
     * 反转指定的结点
     * @param curr
     * @return
     */
    public Node reverse(Node curr){
        if(curr.getNext() == null){
            head.setNext(curr);
            return curr;
        }
        Node node = reverse(curr.getNext());
        node.setNext(curr);
        curr.setNext(null);
        return curr;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        private Node n;
        public MyIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.getNext() != null;
        }

        @Override
        public T next() {
            n = n.getNext();
            return (T)n.getItem();
        }
    }

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insert(1);
        linkList.insert(2);
        linkList.insert(4);
        linkList.insert(5);
        linkList.reverse();
        for(Integer i : linkList){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(linkList.indexOf(4));
        System.out.println();

        linkList.insert(2, 3);
        for(Integer i : linkList){
            System.out.print(i + " ");
        }
        System.out.println();

        boolean eampty = linkList.isEampty();
        int length = linkList.length();
        Integer integer = linkList.get(2);
        System.out.println(eampty + " " + length + " " + integer);

        Integer remove = linkList.remove(2);
        System.out.println(remove);
        for(Integer i : linkList){
            System.out.print(i + " ");
        }
        System.out.println();

        linkList.clear();
    }
}