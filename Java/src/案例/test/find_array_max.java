package 案例.test;

import java.util.Random;
public class find_array_max {
    public static void main(String[] args) {
       Random ra = new Random();
       int [] arr = new int[15];
       for (int i=0;i<15;i++){
           arr[i] = ra.nextInt(10);
           System.out.println(arr[i]);
       }
       int max = arr[0];
       for(int j = 0;j<15;j++){
           if (arr[j]>max){
               max = arr[j];
           }
       }
       System.out.println(max);
    }
}