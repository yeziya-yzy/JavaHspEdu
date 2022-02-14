package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/14
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[80000];
        for (int i = 0; i < 80000; i++) {
            ints[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();//运行前的时间
        // Arrays.sort(ints);//27
        BubbleSort.bubbleSort(ints);
        long end = System.currentTimeMillis();//运行前的时间 9024
        System.out.println("运行时间为" + (end - start));
    }

    //冒泡排序
    //要排序的数组
    // int[] arr = {3, 9, -1, 10, -2};
    public static void bubbleSort(int[] arr) {
        //交换用的临时变量
        int temp = 0;
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;//没有交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;//交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //没有交换说明了有序
            if (!flag) {
                break;
            }
        }
        // 输出
        // for (int item : arr) {
        //     System.out.println(item);
        // }
    }
}
