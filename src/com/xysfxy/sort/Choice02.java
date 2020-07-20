package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/13 16:35
 * @Description:
 * 选择排序，将元素分为两组，一组已经排序，一组没有排序
 * 每次把没有排序的第一个元素插入到已经排序好的队列中
 * 插入方法：逆序比较已经排序好的队列
 * 时间负责度：O(N^2)
 */
public class Choice02 {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 9, 8, 1};

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }else{
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
