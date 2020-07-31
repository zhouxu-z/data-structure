package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/13 15:02
 * @Description:ð�������ʱ�临�Ӷ�O(N^2)
 */
public class Bubbling02 {

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ����
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isSwap(a[j], a[j + 1])) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * �ж�c1�Ƿ����c2
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isSwap(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    /**
     * ����Ԫ��
     * @param a
     * @param i
     * @param j
     */
    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}