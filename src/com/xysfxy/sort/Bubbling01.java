package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: ÷‹±¶ª‘
 * @Date: 2020/7/13 14:49
 * @Description:√∞≈›≈≈–Ú
 */
public class Bubbling01 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 9, 2 ,3, 5};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}