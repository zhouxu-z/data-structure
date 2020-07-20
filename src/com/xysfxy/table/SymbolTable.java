package com.xysfxy.table;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/15 15:54
 * @Description:���ű��ʵ��
 */
public class SymbolTable<Key, Value>{
    private Node head;
    private int N;

    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public Value get(Key key) {
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getKey().equals(key)) {
                return (Value)node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public void put(Key key, Value value) {
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        Node newNode = new Node(key, value, null);
        Node oldNode = head.getNext();
        head.setNext(newNode);
        newNode.setNext(oldNode);
        N++;
    }

    public void delete(Key key) {
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getKey().equals(key)) {
                node.setNext(node.getNext().getNext());
                N--;
                return;
            }
            node = node.getNext();
        }
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        SymbolTable<Integer, String> st = new SymbolTable<>();
        st.put(1, "��");
        st.put(2, "��");
        st.put(3, "��");
        st.put(4, "��");

        System.out.println("������Ԫ�ظ���" + st.size());

        st.put(3, "��");
        System.out.println("�滻���Ԫ�ظ���" + st.size());
        st.delete(1);
        System.out.println("ɾ�����Ԫ�ظ���" + st.size());
        System.out.println(st.get(3));
    }

}