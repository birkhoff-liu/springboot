package com.birkhoff.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 描述:通过一趟排序，将要排序的数据分隔成独立的两部分，其中一部分的所有数据比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此使整个数据变成有序序列。
 * 时间复杂度:最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(nlogn)
 */
public class QuickSort {
    /**
     * 排序方法
     * @param arr 要排序的数组
     * @param low 小的一边
     * @param high 大的一边
     * @return 排序后的数组，toString 方便输出
     */
    public static String quickSort(int[] arr, int low, int high) {

        if(low > high) {
            return Arrays.toString(arr);
        }

        int tmp = arr[low];
        int i = low;
        int j = high;

        while(i < j) {
            //先看右边，依次往左递减，直到找到小于基准数的数字
            while(arr[j] >= tmp && i < j) {
                j--;
            }
            //比基准小的记录移到低端
            arr[i] = arr[j];

            //后看左边，依次往右递增，直到找到大于基准数的数字
            while(arr[i] <= tmp && i < j) {
                i++;
            }
            //比基准大的记录移到高端
            arr[j] = arr[i];
        }

        //记录基准
        arr[i] = tmp;

        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);

        return Arrays.toString(arr);
    }

    public static void main(String[] args) {

        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};

        System.out.println("排序后的数组："+ quickSort(arr, 0, arr.length-1));
    }
}
