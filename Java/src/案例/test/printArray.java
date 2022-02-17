package 案例.test;

public class printArray {
    public static void main(String[] args) {
        int[] arr = {1,5,9,2,7,3,9,6,4};
        printArray(arr);
    }
    public static void printArray(int[] arr){
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
//类：
//创建对象：类名 对象名 = new 类名;
//类中方法定义不要加static其他都和定义方法一样