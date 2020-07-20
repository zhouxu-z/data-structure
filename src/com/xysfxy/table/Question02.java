package com.xysfxy.table;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/14 22:30
 * @Description:快慢指针求单链表是否有环问题
 */
public class Question02<T> {
    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<String> frist = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> six = new Node<>("ff", null);
        Node<String> seven = new Node<>("gg", null);

        frist.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next  = fifth;
        fifth.next = six;
        six.next = seven;

        seven.next = third;

        boolean is = isFun(frist);
        System.out.println(is);
    }

    public static boolean isFun(Node<String> frist){
        Node<String> k = frist;
        Node<String> m = frist;
        while(k != null && k.next != null){
            k = k.next.next;
            m = m.next;
            if(k.equals(m)){
                return true;
            }
        }
        return false;
    }
}