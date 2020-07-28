package com.xysfxy.test;

import com.xysfxy.tree.UfTreeWeighted;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: 周宝辉
 * @date: 2020/7/23 23:02
 * @descripation:畅通工程测试（并查集实现）
 */
public class TrafficProjectTest {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(TrafficProjectTest.class.getClassLoader().getResourceAsStream("trafficProject.txt")));
        int totalNumber = Integer.parseInt(br.readLine());
        int roadNumber = Integer.parseInt(br.readLine());
        UfTreeWeighted uf = new UfTreeWeighted(totalNumber);
        for (int i = 0; i < roadNumber; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            uf.union(p, q);
        }
        System.out.println(uf.count() - 1);
    }

}
