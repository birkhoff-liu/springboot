package com.birkhoff.sort;

import java.util.Arrays;

/**
 * 简单选择排序
 * 思路：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * 时间复杂度：最佳情况：T(n) = O(n2) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 *
 */
public class SelectionSort {
    /**
     * 排序方法
     * @param arr 待排序的数组
     * @return toString 方便输出
     */
    public static String selectionSort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {

            //最小数的索引
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {

                //找到最小数，并记录最小数的索引
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //交换符合条件的数
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组："+ selectionSort(arr));
    }
}
