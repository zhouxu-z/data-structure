package com.xysfxy.sort;

import java.util.Arrays;

/**
 * @Auther: �ܱ���
 * @Date: 2020/7/13 16:35
 * @Description:
 * ѡ�����򣬽�Ԫ�ط�Ϊ���飬һ���Ѿ�����һ��û������
 * ÿ�ΰ�û������ĵ�һ��Ԫ�ز��뵽�Ѿ�����õĶ�����
 * ���뷽��������Ƚ��Ѿ�����õĶ���
 * ʱ�为��ȣ�O(N^2)
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
