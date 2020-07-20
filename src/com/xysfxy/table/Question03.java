package com.xysfxy.table;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/14 22:30
 * @Description:快慢指针求单链表环入口问题
 */
public class Question03<T> {
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

        String is = fun2(frist);
        System.out.println(is);
    }

    public static String fun(Node<String> frist){
        Node<String> k = frist;
        Node<String> m = frist;
        while(k != null && k.next != null){
            k = k.next.next;
            m = m.next;
            if(k.equals(m)){
                Node<String> temp = frist;
                while(k != null && k.next != null){
                    k = k.next.next;
                    m = m.next;
                    temp = temp.next;
                    if(m.equals(temp)){
                        return m.item;
                    }
                }
            }
        }
        return null;
    }

    public static String fun2(Node<String> frist){
        Node<String> k = frist;
        Node<String> m = frist;
        Node<String> temp = null;
        while(k != null && k.next != null){
            k = k.next.next;
            m = m.next;
            if(k.equals(m)){
                temp = frist;
                continue;
            }
            if(temp != null){
                temp = temp.next;
                if(temp.equals(m)){
                    break;
                }
            }
        }
        return temp.item;
    }
}