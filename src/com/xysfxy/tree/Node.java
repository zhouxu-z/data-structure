package com.xysfxy.tree;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/16 17:04
 * @Description:节点类
 */
public class Node<T> {
    private T data;
    private Node left;
    private Node right;

    public Node(){}

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}