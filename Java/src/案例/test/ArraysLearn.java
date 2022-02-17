package 案例.test;

import java.util.Arrays;

public class ArraysLearn {
    public static void main(String[] args) {
        int[] arr = {-1, 12, 5, 2, 4, 7, 1};
        //用系统自带的Arrays进行排序;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}