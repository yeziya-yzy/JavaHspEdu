package StudyNotes.test;

import org.junit.jupiter.api.Test;

public class cesi {
    //    public static void main(String[] args){
//        System.out.println('a'+1);
//    public static void main(String[] args){
//        int i = 1;
//        while( i <= 100 ){
//            if( i%3 == 0){
//                System.out.println("i=" + i);
//            }t
//            i++;
//        }
//
//        int j = 40;
//        while( j <= 200){
//            if( j%2 == 0){
//                System.out.println("j=" + j);
//            }
//            j++;
//        }
//    public static void main(String[] args){
//        for(int y = 1; y<=9; y++){
//            for(int x = 1;x<=y ; x++){
//                System.out.print(x + "*" + y + "="+x*y+"\t");
//            }
//            System.out.println("");
//        }
//    }
//    public static void main(String[] args){
//        int totalLevel = 6;
//        int lie = 2*totalLevel-1;
//
//        for (int kong =totalLevel-1;kong>=0;kong--){
//            for (int i = 1 ;i <= kong;i++){
//                System.out.print(" ");
//            }
//            for (int i = 1 ;i <= lie-2*kong;i++){
//                System.out.print("*");
//            }
//            System.out.println("");
//        }
//
//
//        for (int kong =totalLevel-1;kong>=0;kong--){
//            for (int i = 1 ;i <= kong;i++){
//                System.out.print(" ");
//            }
//            for (int i = 1 ;i <= lie-2*kong;i++){
//                if(i > 1 && i < lie-2*kong && kong>0){
//                    System.out.print(" ");
//                }else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println("");
//        }
//
//
//        for (int kong =totalLevel-1;kong>=0;kong--){
//            for (int i = 1 ;i <= kong;i++){
//                System.out.print(" ");
//            }
//            for (int i = 1 ;i <= lie-2*kong;i++){
//                if(i > 1 && i < lie-2*kong && kong>0){
//                    System.out.print(" ");
//                }else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println("");
//        }
//        for (int kong =1;kong<=totalLevel-1;kong++){
//            for (int i = 1 ;i <= kong;i++){
//                System.out.print(" ");
//            }
//            for (int i = 1 ;i <= lie-2*kong;i++){
//                if(i > 1 && i < lie-2*kong){
//                    System.out.print(" ");
//                }else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println("");
//        }
//    public static void main(String[] args){
//        Scanner myscanner = new Scanner(System.in);
//        int max = 3;
//        for(int chance = 1; chance<=max ; chance++){
//            System.out.println("请输入用户名字:");
//            String name = myscanner.next();
//            System.out.println("请输入密码:");
//            int password = myscanner.nextInt();
//            if("丁真".equals(name) && password == 666){
//                System.out.println("输入正确");
//                break;
//            }else {
//                System.out.println("输入错误,还有"+ (max-chance) +"次机会");
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int hang = 5;
//        int i = 0 ;
//        for (int number = 1; number <= 100; number++) {
//            if (number % 5 != 0) {
//                if(i == hang){
//                    System.out.println(" ");
//                    i = 0 ;
//                }else{
//                    System.out.print(number + "\t");
//                    i++;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        for (char i = 97; i<=97+25;i++){
//            System.out.print(i);
//        }
//        for(char i = 'a'; i <= 'z' ,i++){
//            System.out.print(i);}
//        System.out.println();
//        for (char i = 65+25; i>=65;i--){
//            System.out.print(i);
//        }
//    }
//    public static void main(String[] args) {
//        double sum = 0.0;
//        for(int i = 1; i <= 100 ; i++){
//            sum += Math.pow(-1,i-1)*(1.0/i);
//        }
//        System.out.println(sum);  //0.688172179310195
//    }
//    public static void main(String[] args) {
//        int sum = 0;
//        for(int i = 1; i <=100; i++){
//            for(int j = 1 ; j <= i ;j++){
//                sum += j;
//            }
//        }
//        System.out.println(sum); //171700
//    }
//    public static void main(String[] args){
//        double moneny = 100000;
//        int count = 0;
//        while ( true ){
//            if( moneny >50000){
//                moneny -= moneny*0.05;
//                count +=1;
//            }
//            else if ( 1000<moneny ){
//                moneny -= 1000;
//                count +=1;
//            }
//            else {
//                break;
//            }
//        }
//        System.out.println(count);
//    }
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        Scanner my_Scanner = new Scanner(System.in);
//        System.out.println("输入要加入的数据个数");
//        int changeLength = my_Scanner.nextInt();
//        int[] arrNew = new int[arr.length + changeLength];
//        while (true) {
//            for ( int i = 0 ; i < arr.length ; i++ ){
//                arrNew[i] = arr[i];
//            }
//            for ( int i = arr.length ; i < arr.length + changeLength ; i++ ){
//                System.out.println("输入要加入的数据");
//                int inputText = my_Scanner.nextInt();
//                arrNew[i] = inputText;
//            }
//            arr = arrNew;
//            for ( int i = 0 ; i < arr.length ; i++ ){
//                System.out.println(arr[i]);
//            }
//            break;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner myScanner = new Scanner(System.in);
//        String inputFloat = "";
//        int[] arr = {1,2,3};
//        do{
//            int[] arrNew = new int[arr.length + 1];
//            for (int i = 0 ; i < arr.length ;i++){
//                arrNew[i]=arr[i];
//            }
//            System.out.println("要加入的数字");
//            int addtext = myScanner.nextInt();
//            arrNew[arr.length] = addtext;
//            arr = arrNew;
//            for (int i = 0 ; i < arr.length ;i++){
//                System.out.println(arr[i]);
//            }
//            System.out.println("是否还要加入数字(y/n)");
//            inputFloat = myScanner.next();
//
//        }while("y".equals(inputFloat));
//        System.out.println("程序已经推出");
//    }
//    public static void main(String[] args) {
//        //定义行数和二维数组
//        int hang = 10;
//        int[][] arr = new int[hang][];
//        //循环到每一个一维数组
//        for (int i = 0 ; i < hang ; i++){
//            //为一维数组定义长度
//            arr[i] = new int[i+1];
//            //循环到每一个一维数组下的每一个数
//            for ( int j = 0 ; j < arr[i].length ; j++){
//                //判断是否是第一个或者最后一个
//                if (j == 0 || j == i){
//                    arr[i][j] = 1;
//                }else {
//                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
//                }
//            }
//        }
//        //打印二维数组中的数字
//        System.out.println("=============================");
//        for (int i = 0 ; i < hang ; i++){
//            for ( int j = 0 ; j < arr[i].length ; j++){
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        int[] arr01 = {10,12,22,33,45,90};
//        int number = 23;
//        int[] arr02 = new int[arr01.length+1];
//        for (int i = 0 ; i < arr02.length ; i++){
//            if (i == arr01.length){
//                arr02[i] = number;
//            } else if (arr01[i] < number){
//                arr02[i] = arr01[i];
//            }else {
//                arr02[i] = number;
//                for (int j = i + 1 ; j < arr02.length ; j++){
//                    arr02[j] = arr01[j - 1];
//                }
//                break;
//            }
//        }
//        arr01 = arr02;
//        for (int i = 0 ; i < arr01.length ; i++ ){
//            System.out.print(arr01[i] + " ");
//        }
//    public static void main(String[] args) {
//        int[] arr = {1, 3, 6, 21, -3, -6, 2134, -653, 1234, 56};
//        int temp = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
}

class AA {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 1;
        for (int i = 1; i <= 80000; i++) {
            sum *= i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}