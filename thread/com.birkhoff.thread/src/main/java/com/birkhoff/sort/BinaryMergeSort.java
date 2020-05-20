package com.birkhoff.sort;

import java.util.Arrays;

public class BinaryMergeSort {
    public static void main(String[] args) {
        int data[] = {9,5,8,0,3,7,1};
        mergeSort(data,0,data.length - 1);
        System.out.println("排完后的序列：");
        System.out.println(Arrays.toString(data));
    }

    public static  void mergeSort(int data[],int left,int right){
        //分治
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(data,left,mid);
            mergeSort(data,mid + 1,right);
            //分完了
            meger(data,left,mid,right);
        }
    }
    public static void meger(int data[],int left,int mid,int right){
        int temp[] = new int[data.length];
        int point1 = left;
        int point2 = mid + 1;

        int index = left;

        while(point1 <= mid && point2 <= right){
            if(data[point1] <= data[point2]){
                temp[index] = data[point1];
                index++;
                point1++;
            }else {
                temp[index] = data[point2];
                index++;
                point2++;
            }
        }
        while (point1 <= mid){
            temp[index++] = data[point1++];
        }
        while (point2 <= right){
            temp[index++] = data[point2++];
        }
        for (int i = left ; i <= right ;i++){
            data[i] = temp[i];
        }
    }
}

