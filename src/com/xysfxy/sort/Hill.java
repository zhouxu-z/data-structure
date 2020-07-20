package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: ÷‹±¶ª‘
 * @Date: 2020/7/13 17:07
 * @Description:œ£∂˚≈≈–Ú
 */
public class Hill {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 7, 9, 2, 1};
        int h = 1;
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
        System.out.println(Arrays.toString(arr));
    }

}