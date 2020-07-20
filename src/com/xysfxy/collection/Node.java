package com.xysfxy.collection;

/**
 * @Auther: ÷‹±¶ª‘
 * @Date: 2020/7/16 16:21
 * @Description:
 */
public class Node<T>{
    private T item;
    private Node next;

    public Node(T item,Node next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}