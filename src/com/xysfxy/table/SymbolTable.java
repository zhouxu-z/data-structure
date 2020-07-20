package com.xysfxy.table;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/15 15:54
 * @Description:符号表的实现
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
        st.put(1, "周");
        st.put(2, "序");
        st.put(3, "宝");
        st.put(4, "辉");

        System.out.println("插入后的元素个数" + st.size());

        st.put(3, "程");
        System.out.println("替换后的元素个数" + st.size());
        st.delete(1);
        System.out.println("删除后的元素个数" + st.size());
        System.out.println(st.get(3));
    }

}