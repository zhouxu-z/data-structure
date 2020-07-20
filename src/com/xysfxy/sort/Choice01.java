package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: 周宝辉
 * @Date: 2020/7/13 15:31
 * @Description:选择排序，每次选出最小的，时间复杂度O(N^2)
 */
public class Choice01 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 9, 8, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
//i=0 1 6 2 7 9 8 4
//i=1 1 2 6 7 9 8 4
//i=2 1 2 4 7 9 8 6
//i=3 1 2 4 6 9 8 7
//i=4 1 2 4 6 7 8 9