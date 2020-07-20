package com.xysfxy.tree;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/15 18:00
 * @Description:二叉查找树
 */
public class BinatyTree<T extends Comparable> {
    private Node root;//树根

    private class Node <T extends Comparable>{
        private T data;//数据域
        private Node left;//左子树
        private Node right;//右子树

        Node(T data) {//构造函数
            this.data = data;
            Node lift = null;
            Node right = null;
        }

        public void addNode(Node newNode, T data) {
            if (this.data.compareTo(newNode.data) > 0) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode, data);
                }
            }
            if (this.data.compareTo(newNode.data) <= 0) {
                if (this.right == null) {
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode, data);
                }
            }
        }

        public void show(Node node){
            if(node == null){
                return;
            }
            System.out.print(node.data + " ");
            show(node.left);
            show(node.right);
        }

    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode, data);
        }
    }

    /**
     * 查找树中最小的值
     * @return
     */
    public T min(){
        return (T)min(root).data;
    }

    private Node min(Node node){
        if(node.left != null){
            return min(node.left);
        }
        return  node;
    }

    /**
     * 查找树中最大的值
     * @return
     */
    public T max(){
        return (T)max(root).data;
    }

    private Node max(Node node){
        if(node.right != null){
            return max(node.right);
        }
        return  node;
    }

    /**
     * 查找树中的值
     * @param data
     * @return
     */
    public Node isFun(T data){
        Node node = root;
        while(node.data.compareTo(data) != 0){
            if(node.data.compareTo(data) > 0){
                 node = node.left;
            }else if(node.data.compareTo(data) < 0){
                node = node.right;
            }
            if(node == null){
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        BinatyTree<Integer> tree = new BinatyTree<>();
        tree.add(6);
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(1);
        tree.add(2);
        System.out.println(tree.min());
        System.out.println(tree.max());

        if(tree.isFun(4) != null){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}





















