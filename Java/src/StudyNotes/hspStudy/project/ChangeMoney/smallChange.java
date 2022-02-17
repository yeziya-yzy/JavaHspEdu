package StudyNotes.hspStudy.project.ChangeMoney;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputeNumber = "";
        boolean SignOut = true;
        double balance =0;
        double money = 0;
        Date date = null;
        String con = "";//消费类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化的
        String details = "-----------------零钱通明细------------------";
        do {
            System.out.println("================零钱通菜单===============");
            System.out.println("\t\t\t1 零钱通明细\n" +
                               "\t\t\t2 收益入账\n" +
                               "\t\t\t3 消费\n" +
                               "\t\t\t4 退     出");
            System.out.print("请选择(1-4): ");
            inputeNumber = scanner.next();
            switch (inputeNumber) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("请输入收益入账金额:");
                    money = scanner.nextDouble();
                    balance += money;
                    date = new Date(); //获取当前日期
                    details += "\n收益入账\t+"+money+"  \t"+sdf.format(date)+"\t"+"余额为:"+balance;
                    break;
                case "3":
                    System.out.print("请输入消费类型:");
                    con = scanner.next();
                    System.out.print("请输入消费金额:");
                    money = scanner.nextDouble();
                    if(money > balance){
                        System.out.println("消费金额>余额");
                    }
                    balance-=money;
                    details += "\n"+con+"\t-"+money+"  \t"+sdf.format(date)+"\t"+"余额为:"+balance;
                    break;
                case "4":
                    while (true) {
                        System.out.print("你确定要退出吗(y/n)? ");
                        con = scanner.next();
                        if ("y".equals(con)) {
                            SignOut = false;
                            break;
                        } else if ("n".equals(con)) {
                            System.out.print("零钱通继续\n");
                            break;
                        } else {
                            System.out.print("请输入(y/n)\n");
                        }
                    }
                    break;
                default:
                    System.out.println("请输入正确的数字\n");
            }
        } while (SignOut);
        System.out.println("程序已经退出");
    }
}
