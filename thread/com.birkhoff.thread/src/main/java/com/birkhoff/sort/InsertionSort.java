package com.birkhoff.sort;

import lombok.Synchronized;

import java.util.Arrays;

/**
 * 插入排序
 * 描述：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，
 * 通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 * 时间复杂度：最佳情况：T(n) = O(n) 最坏情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 */
public class InsertionSort {
    /**
     * 排序方法
     * @param arr 待排序的数组
     * @return toString 方便输出
     */
    public static  String insertionSort(int[] arr) {

        //当前正在比较的数字（下方简称：“当前”）
        int current;
        for(int i=0; i<arr.length-1; i++) {

            current = arr[i + 1];
            //“当前”前面的数字的索引
            int preIndex = i;

            //找到比“当前”小的数字
            while(preIndex >= 0 && current < arr[preIndex]) {
                //向后移动已排好序的，大于“当前”的数字
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }

            //插入“当前”到相应的位置
            arr[preIndex+1] = current;
        }

        return Arrays.toString(arr);
    }


    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组："+ insertionSort(arr));
    }
}
