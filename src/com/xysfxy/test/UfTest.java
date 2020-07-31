package com.xysfxy.test;

import com.xysfxy.tree.Uf;

import java.util.Scanner;

/**
 * @author: 周宝辉
 * @date: 2020/7/23 18:33
 * @descripation:测试并查集
 */
public class UfTest {

    public static void main(String[] args) {
        Uf uf = new Uf(5);
        System.out.println("默认情况下，并查集中有" + uf.count() + "个分组");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("请输入第一个要合并的元素：");
            int a = scanner.nextInt();
            System.out.print("请输入第二个要合并的元素：");
            int b = scanner.nextInt();
            if(uf.connected(a, b)){
                System.out.println("这两个元素已经在一个组中了");
                continue;
            }
            uf.union(a, b);
            System.out.println("合并之后还有" + uf.count() + "个分组");
        }

    }

}
