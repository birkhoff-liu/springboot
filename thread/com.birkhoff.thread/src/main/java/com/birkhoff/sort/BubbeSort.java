package com.birkhoff.sort;

import java.util.Scanner;

/**
 * 冒泡排序 实现
 */
public class BubbeSort {
    public static void main(String[] args) {

        int data[] = {3,4,6,8,1,0};


        for(int i = 0 ; i  < data.length ; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();

        for(int i = 0 ,len = data.length ; i < len -1 ; i++){
            for(int j = 0 ; j < len - 1 - i ; j++){
                if(data[j] > data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        for(int i = 0 ; i  < data.length ; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();

    }
}
