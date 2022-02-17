package 案例.test;

public class Fitst_Java {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0]=1;
        a[1]=9;
        a[2]=52;
        for (int i = 0;i<3;i++){
            System.out.println(a[i]);
        }
     /*   int[] b = new int[]{1,2,3};
        int [] c ={1,2,3,};*/
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);*/
    }
    /*public static void main(String[] args) {
        Random ne = new Random();
        int a = ne.nextInt(10); //获取0-9的随机数
        int b = ne.nextInt(10);
        System.out.println(a);
        System.out.println(b);
        boolean c = add(a, b);
        System.out.println(c);
    }

    public static boolean add(int a, int b) { ;
        return a==b;
    }
    int[] a = new int[3];
    int[] b = new int[]{1,2,3};
    int [] c ={1,2,3,};*/
    /*public static void main(String[] args) {
        public static int add(int a,int b){
            int c = a+b;
            return c;
        }

        *//*Random a = new Random();
        int i = a.nextInt(10); //获取0-9的随机数
        System.out.println(i);*//*
    }*/
    /*public static int add (int a,int b){
        int c = a+b;
        return c;
    }*/
}
//修饰符 返回值类型 方法名(参数类型 参数名1，参数类型 参数名2...){
//      方法体语句;
//      return 返回值
//}
/*    public static void main(String[] args) {
*//*        int pepele_number = 105;
        int ornge_number = 100;
        if(pepele_number>ornge_number){
            System.out.println("橙子不够");
        }else{
            System.out.println("每一个人都获得到橙子");
        }
        int i = 1;
        int j = 1;
        while (i<=3){
            while (j<=10){
                System.out.println(i +"班"+ j +"号");
                j++;
            }
            i++;
        }*//*
*//*        int i = 0;
        int j = 0;*//*
        for(int i = 0;i<=10;i++){
            for(int j = 0;j <= 10;j++){
                System.out.println(i +"班"+ j +"号");
            }
        }
    }*/


/*    public static void main(String[] args){   //快捷键 psvm
        System.out.println("Hello Word");   ////快捷键sout
        //创建键盘输入对象
        Scanner sc = new Scanner(System.in);
        //接收数据
        System.out.println("请输入一个整数：");
        int i = sc.nextInt();//接收用户输入的数据
        System.out.println("请输入一个整数：");
        int j = sc.nextInt();
        System.out.println(i);
        System.out.println(j);
        int sum = i+j;
        System.out.println(sum);
        if (i == j){
            System.out.println("XXX");
        }else if(i < j) {
            System.out.println("YYY");
        }else {
            System.out.println("ZZZ");
        }
    }*//*

*/
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数字(1-7)；");
        int i = sc.nextInt();
        switch (i){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期天");
                break;
        }
    }*//*

    //循环  for  while  do...whlie
    public static void main(String[] args) {
        */
/*for(初始化语句;判断语句;控制条件语句){
            循环体
        }*//*

//        int s = 0;
//        int d = 0;
//        for(int i = 100 ;i <= 999 ;i++){
//            int a = i%10;
//            int b = i/10%10 ; //也可以是   int b = i%100/10
//            int c = i/100;
//            if (a*a*a + b*b*b + c*c*c == i ){
//                System.out.println(i);
//                d++;
//            }
//        }
//        System.out.println(d);
//        for(int i = 5 ;i>=1; i--){
//            System.out.println(i);
//        }
//        int i = 1;
//        int sum = 0;
//        while (i <= 100){
//            //System.out.println("Hello Word");
//            sum += i;
//            i++;
//        }
//        System.out.println(sum);
//        初始化语句;
//        do{
//            循环体语句;
//            控制条件语句;
//        }whlie(判断条件语句);
//        boolean Flag = false;
//        int count = 1;
//        do{
//            System.out.println("正在学习"+count+"次");
//            if(count >= 3 ){
//                System.out.println("学习成功");
//                Flag = true;
//            }
//            count+=1;
//        }while(Flag == false);
*/
/*        for (int i = 1; i <= 3; i++){
            for (int j = 1; j<=5; j++){
                System.out.println("我是"+i+"班的"+j+"号学生");
            }
        }*//*

        System.out.println("请输入人数");
        Scanner sc =new  Scanner(System.in);
        int pepele_number = sc.nextInt();
        int ornge_number = 105;
        if(pepele_number>ornge_number){
            System.out.println("橙子不够");
        }else{
            System.out.println("每一个人都获得到橙子");
        }
*/
/*        for(int  i = 1 ;i <= 3; i++ ){
            for (int j = 1;j <= 35; j++){
                System.out.println(i + "班"+j+"号同学得到橙子");
                ornge_number-=1;
                    for(int a = i;a<=3;a++){
                        for(int b = j;b<=35;b++){
                            System.out.println(a + "班"+b+"号同学没用得到橙子");
                        }
                    }*//*

                }
        }
    */
