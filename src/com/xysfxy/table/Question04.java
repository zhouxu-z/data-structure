package com.xysfxy.table;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/14 22:30
 * @Description:约瑟夫问题
 */
public class Question04<T> {
    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> frist = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            if(i == 1){
                frist = new Node<>(i, null);
                pre = frist;
                continue;
            }
            Node<Integer> node = new Node<>(i, null);
            pre.next = node;
            pre = node;
            if(i == 41){
                pre.next = frist;
            }
        }

        int count = 0;
        Node<Integer> n = frist;
        Node<Integer> before = null;
        while(n != n.next){
            count++;
            if(count == 3){
                before.next = n.next;
                System.out.print(n.item + ",");
                count=0;
                n = n.next;
            }else{
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.item);
    }
}