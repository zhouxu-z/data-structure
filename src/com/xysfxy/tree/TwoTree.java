package com.xysfxy.tree;


import java.util.LinkedList;
import java.util.List;

public class TwoTree<T> {

    public void creatBinaryTree(T[] datas, List<Node> nodelist) {
        //将数组变成node节点
        for (int nodeindex = 0; nodeindex < datas.length; nodeindex++) {
            Node node = new Node(datas[nodeindex]);
            nodelist.add(node);
        }
        //给所有父节点设定子节点
        for (int index = 0; index < nodelist.size() / 2 - 1; index++) {
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            //这里父节点有1（2,3）,2（4,5）,3（6,7）,4（8,9） 但是最后一个父节点有可能没有右子节点 需要单独处理
            nodelist.get(index).setLeft(nodelist.get(index * 2 + 1));
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
        //单独处理最后一个父节点  因为它有可能没有右子节点
        int index = nodelist.size() / 2 - 1;
        nodelist.get(index).setLeft(nodelist.get(index * 2 + 1)); //先设置左子节点
        if (nodelist.size() % 2 == 1) { //如果有奇数个节点，最后一个父节点才有右子节点
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
    }

    /**
     * 先序遍历（根左右）
     *
     * @param node
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    /**
     * 中序遍历(左右根)
     *
     * @param node
     */
    public void middlePreface(Node node) {
        if (node != null) {
            middlePreface(node.getLeft());
            System.out.print(node.getData() + " ");
            middlePreface(node.getRight());
        }
    }

    /**
     * 后序遍历（左右根）
     *
     * @param node
     */
    public void afterword(Node node) {
        if (node != null) {
            afterword(node.getLeft());
            afterword(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public static void main(String[] args) {
        TwoTree tree = new TwoTree();
        //Integer[] arr = {1,2,3,4,5,6,7,8};
        Character[] arr = {'A', 'B', 'C', 'D'};
        List<Node> list = new LinkedList<>();
        tree.creatBinaryTree(arr, list);
        System.out.println("先序遍历");
        tree.preorder(list.get(0));
        System.out.println();
        System.out.println("中序遍历");
        tree.middlePreface(list.get(0));
        System.out.println();
        System.out.println("后序遍历");
        tree.afterword(list.get(0));
    }
}
