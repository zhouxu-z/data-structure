package com.xysfxy.table;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/15 15:54
 * @Description:有序符号表的实现
 */
public class OrderSymbolTable<Key extends Comparable, Value>{
    private Node head;
    private int N;

    public OrderSymbolTable() {
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
        Node node = head.getNext();
        Node temp = head;
        while(node != null && key.compareTo(node.getKey()) > 0){
            temp = node;
            node = node.getNext();
        }
        if(node != null && key.compareTo(node.getKey()) == 0){
            node.setValue(value);
        }else{
            Node keyValueNode = new Node(key, value, node);
            temp.setNext(keyValueNode);
            N++;
        }
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
        OrderSymbolTable<Integer, String> st = new OrderSymbolTable<>();
        st.put(1, "周");
        st.put(2, "序");
        st.put(4, "宝");
        st.put(7, "辉");

        st.put(3,"a");

        System.out.println();

    }

}