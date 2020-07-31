package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/13 21:52
 * @Description:�鲢����
 */
public class Merger {
    private static int[] assist;

    public static void sort(int[] a, int lo, int hi) {
        assist = new int[a.length];
        if(lo < hi){
            int mid = (lo + hi) / 2;//����
            sort(a, lo, mid);//����
            sort(a, mid + 1, hi);//����
            merge(a, lo, mid, hi);//�鲢
        }
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi){
            if(a[p1] < a[p2]){
                assist[i++] = a[p1++];
            }else{
                assist[i++] = a[p2++];
            }
        }
        while(p1 <= mid){
            assist[i++] = a[p1++];
        }
        while(p2 <= hi){
            assist[i++] = a[p2++];
        }
        for (int j = lo; j <= hi; j++) {
            a[j] = assist[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        new Merger().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}