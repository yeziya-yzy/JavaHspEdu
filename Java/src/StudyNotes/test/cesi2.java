package StudyNotes.test;
import java.util.Random;
import java.util.Scanner;
public class cesi2 {
    public static void main(String[] args){
        // A01 a01 = new A01();
        // double[] arr = {1.1,2.5,9.8,7.4,10.2};
        // System.out.println(a01.max(arr));
        // A02 a02 = new A02();
        // String[] arr = {"1" , "qll" , "wyw" , "bb"};
        // a02.find(arr , "1");
        //Book book = new Book("第一本书",11);
        //book.updataPrice();
        //A03 a03 = new A03();
        //int[] arr = {1,45,2,532,23,51};
        //int[] newArr = new int[arr.length];
        //newArr = a03.copyArr(arr);
        //for (int i = 0 ; i < arr.length ; i++){
        //  System.out.println(newArr[i]);
        //Circle circle = new Circle(3);
        //System.out.println("面积为"+ circle.area() +"\t"+ "周长为" + circle.len());
        //Cale cale = new Cale(123,0);
        //Double divRes = cale.Division();
        //if (divRes != null){
        //      System.out.println(cale.Division());
        //}
        //System.out.println(cale.Add());
        //Circle2 c = new Circle2();
        //PassObject passObject = new PassObject();
        //passObject.printAreas(c,12);


        // 创建一个玩家对象
        Tom t = new Tom();
        // 用来记录最后输赢的次数
        int isWinCount = 0;

        // 创建一个二维数组，用来接收局数，Tom出拳情况以及电脑出拳情况
        int[][] arr1 = new int[3][3];
        int j = 0;

        // 创建一个一维数组，用来接收输赢情况
        String[] arr2 = new String[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {   //比赛3次
            // 获取玩家出的拳
            System.out.println("请输入你要出的拳（0-拳头，1-剪刀，2-布）：");
            int num = scanner.nextInt();
            t.setTomGuessNum(num);
            int tomGuess = t.getTomGuessNum();
            arr1[i][j + 1] = tomGuess;

            // 获取电脑出的拳
            int comGuess = t.computerNum();
            arr1[i][j + 2] = comGuess;

            // 将玩家猜的拳与电脑做比较
            String isWin = t.vsComputer();
            arr2[i] = isWin;
            arr1[i][j] = t.count;

            // 对每一局的情况进行输出
            System.out.println("=========================================");
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");
            System.out.println(t.count + "\t" + tomGuess + "\t\t" + comGuess + "\t\t" + t.vsComputer());
            System.out.println("=========================================");
            System.out.println("\n\n");
            isWinCount = t.winCount(isWin);
        }

        // 对游戏的最终结果进行输出
        System.out.println("局数\t玩家的出拳\t电脑的出拳\t\t输赢情况");
        for (int a = 0; a < arr1.length; a++) {
            for (int b = 0; b < arr1[a].length; b++) {
                System.out.print(arr1[a][b] + "\t\t\t");
            }

            System.out.print(arr2[a]);
            System.out.println();
        }
        System.out.println("你赢了" + isWinCount + "次");
    }

}

class A01 {
    public double max(double[] arr){
        double maxnumber = arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            if (arr[i] > maxnumber){
                maxnumber = arr[i];
            }
        }
        return maxnumber;
    }
}

class A02{
    public int find(String[] arr , String findStr){
        int index = -1;
        for (int i = 0 ; i < arr.length ; i++){
            if (findStr.equals(arr[i])){
                index = i;
                System.out.println("有找到字符串" + findStr + "下标为" + index);
            }
        }
        if (index == -1){
            System.out.println("没有找到字符串" + findStr);
        }
        return index;
    }
}

class Book{
    int money;
    String name;
    public Book(String name,int money){
        this.name =name;
        this.money = money;
    }
    public void updataPrice(){
        if ( this.money>150 ){
            this.money = 150;
        }else if (this.money>100){
            this.money = 100;
        }
        this.print();
    }
    public void print(){
        System.out.println(this.name + this.money + "元");
    }
}

class A03 {
    public int[] copyArr(int[] arr ){
        int[] newArr = new int[arr.length];
        for (int i = 1 ; i < arr.length ; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
}

class Circle{
    int r;
    public Circle(int r){
        this.r = r;
    }

    public double area(){
        return Math.PI  * r * r;
    }

    public double len(){
        return Math.PI  * 2 * r;
    }
}

class Cale {
    int firstNumber;
    int SecondNumber;
    public Cale(int firstNumber , int SecondNumber){
        this.firstNumber =firstNumber;
        this.SecondNumber =SecondNumber;
    }
    public int Add(){
        return this.firstNumber+this.SecondNumber;
    }
    public int Reduce(){
        return this.firstNumber-this.SecondNumber;
    }
    public int Multiplication(){
        return this.firstNumber*this.SecondNumber;
    }
    public Double Division(){
        if ( this.SecondNumber == 0 ){
            System.out.println("除数不能为零");
            return null;
        }else{
            return (double)this.firstNumber/this.SecondNumber;
        }
    }
}

class Dog{
    String name;
    String color;
    int age;
    public Dog(String name,String color,int age){
        this.name = name;
        this.color = color;
        this.age =age;
        this.show();
    }
    public void show(){
        System.out.println(this.name+this.color+this.age);
    }
}

class Circle2{
    double radius ;
    public double findArea(double radius){
        return Math.PI * radius * radius;
    }
}

class PassObject {
    Circle2 circle2;
    int times;

    //    public PassObject(Circle2 circle2,int times){
//        this.circle2 = circle2 ;
//        this.times = times;
//        this.printAreas();
//    }
//
//    public void printAreas(){
//        System.out.println("Radius" + "\t" + "Areas" );
//        for (int i = 1 ; i <= times ; i++ ){
//            System.out.println(i + "\t    " + circle2.findArea((double)i)) ;
//        }
//    }
    public void printAreas(Circle2 circle2,int times){
        System.out.println("Radius" + "\t" + "Areas" );
        for (int i = 1 ; i <= times ; i++ ){
            System.out.println((double)i + "\t    " + circle2.findArea((double)i)) ;
        }
    }
}

class Tom {     // 核心代码
    // 玩家出拳的类型
    int tomGuessNum; //0,1,2
    // 电脑出拳的类型
    int comGuessNum; //0,1,2
    // 玩家赢的次数
    int winCountNum;
    // 比赛的次数
    int count = 1;   //一共比赛3次


    public void showInfo() {
        //....
    }
    /**
     * 电脑随机生成猜拳的数字的方法
     *
     * @return
     */
    public int computerNum() {
        Random r = new Random();
        comGuessNum = r.nextInt(3);      // 方法 返回 0-2的随机数
        // System.out.println(comGuessNum);
        return comGuessNum;
    }

    /**
     * 设置玩家猜拳的数字的方法
     *
     * @param tomGuessNum
     */
    public void setTomGuessNum(int tomGuessNum) {
        if (tomGuessNum > 2 || tomGuessNum < 0) {
            //抛出一个异常, 李同学会写，没有处理
            throw new IllegalArgumentException("数字输入错误");
        }
        this.tomGuessNum = tomGuessNum;
    }

    public int getTomGuessNum() {
        return tomGuessNum;
    }

    /**
     * 比较猜拳的结果
     *
     * @return 玩家赢返回true，否则返回false
     */
    public String vsComputer() {
        //比较巧
        if (tomGuessNum == 0 && comGuessNum == 1) {
            return "你赢了";
        } else if (tomGuessNum == 1 && comGuessNum == 2) {
            return "你赢了";
        } else if (tomGuessNum == 2 && comGuessNum == 0) {
            return "你赢了";
        } else if (tomGuessNum == comGuessNum) {
            return "平手";
        } else {
            return "你输了";
        }
    }

    /**
     * 记录玩家赢的次数
     *
     * @return
     */
    public int winCount(String s) {
        count++;    //控制玩的次数
        if (s.equals("你赢了")) {     //统计赢的次数
            winCountNum++;
        }
        return winCountNum;
    }
}
