package 案例.test;

public class Find_Prime_number {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个整数：");
//        int inpute_number = sc.nextInt();//接收用户输入的数据
        for(int i = 3;i<=100;i++){
            boolean panduan = false;
            for(int j=2;j<i;j++){
                //判断是否被j整除
                if(i%j==0){
                    panduan =false;
                    break;
                }else {
                    panduan = true;
                }
            }
            if(panduan){
                System.out.println(i);
            }
        }
    }
}
