package com.xysfxy.tree;


import java.util.LinkedList;
import java.util.List;

public class TwoTree<T> {

    public void creatBinaryTree(T[] datas, List<Node> nodelist) {
        //��������node�ڵ�
        for (int nodeindex = 0; nodeindex < datas.length; nodeindex++) {
            Node node = new Node(datas[nodeindex]);
            nodelist.add(node);
        }
        //�����и��ڵ��趨�ӽڵ�
        for (int index = 0; index < nodelist.size() / 2 - 1; index++) {
            //���Ϊn�Ľڵ��������ӽڵ���Ϊ2*n ���ӽڵ���Ϊ2*n+1 ������Ϊlist��0��ʼ��ţ����Ի�Ҫ+1
            //���︸�ڵ���1��2,3��,2��4,5��,3��6,7��,4��8,9�� �������һ�����ڵ��п���û�����ӽڵ� ��Ҫ��������
            nodelist.get(index).setLeft(nodelist.get(index * 2 + 1));
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
        //�����������һ�����ڵ�  ��Ϊ���п���û�����ӽڵ�
        int index = nodelist.size() / 2 - 1;
        nodelist.get(index).setLeft(nodelist.get(index * 2 + 1)); //���������ӽڵ�
        if (nodelist.size() % 2 == 1) { //������������ڵ㣬���һ�����ڵ�������ӽڵ�
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
    }

    /**
     * ��������������ң�
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
     * �������(���Ҹ�)
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
     * ������������Ҹ���
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
        System.out.println("�������");
        tree.preorder(list.get(0));
        System.out.println();
        System.out.println("�������");
        tree.middlePreface(list.get(0));
        System.out.println();
        System.out.println("�������");
        tree.afterword(list.get(0));
    }
}
