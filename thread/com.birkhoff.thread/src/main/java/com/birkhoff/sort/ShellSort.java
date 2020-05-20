package com.birkhoff.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 思路：希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，
 * 也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，
 * 整个文件恰被分成一组，算法便终止。
 * 时间复杂度：最佳情况：T(n) = O(nlog2 n) 最坏情况：T(n) = O(nlog2 n) 平均情况：T(n) =O(nlog2n)
 */
public class ShellSort {
    /**
     * 排序方法
     * @param arr 待排序的数组
     * @return toString 方便输出
     */
    public static String shellSort(int[] arr) {

        //当前正在比较的数字（下方简称：“当前”）
        int current;
        //初始增量（此处为：希尔增量）
        int gap = arr.length / 2;

        //gap=1的时候，数组已经有序
        while(gap > 0) {
            for(int i = gap; i < arr.length; i++) {
                current = arr[i];
                //与“当前”同组的前一个数字
                int preIndex = i - gap;

                //找到同组内比“当前”小的数字
                while(preIndex >= 0 && current < arr[preIndex]) {
                    //在向后移动同组内已排好序的，大于“当前”的数字
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                //插入“当前”到相应的位置
                arr[preIndex + gap] = current;
            }
            //缩小增量
            gap /= 2;
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println("排序后的数组："+ shellSort(arr));
    }
}
