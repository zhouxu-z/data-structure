package com.xysfxy.test;

import com.xysfxy.tree.Uf;

import java.util.Scanner;

/**
 * @author: �ܱ���
 * @date: 2020/7/23 18:33
 * @descripation:���Բ��鼯
 */
public class UfTest {

    public static void main(String[] args) {
        Uf uf = new Uf(5);
        System.out.println("Ĭ������£����鼯����" + uf.count() + "������");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("�������һ��Ҫ�ϲ���Ԫ�أ�");
            int a = scanner.nextInt();
            System.out.print("������ڶ���Ҫ�ϲ���Ԫ�أ�");
            int b = scanner.nextInt();
            if(uf.connected(a, b)){
                System.out.println("������Ԫ���Ѿ���һ��������");
                continue;
            }
            uf.union(a, b);
            System.out.println("�ϲ�֮����" + uf.count() + "������");
        }

    }

}
