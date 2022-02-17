package 案例.HomeWork.hspdeuHomeWork.ExceptionHomeWork;

import java.util.Scanner;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数1:");
        String string1 = scanner.next();
        System.out.print("请输入数2:");
        String string2 = scanner.next();
        int n1,n2;
        try {
            n1 = Integer.parseInt(string1);
            n2 = Integer.parseInt(string2);
            cal(n1,n2);
        } catch (NumberFormatException e) {
            System.out.println("数据类型不正确");
        }
    }
    public static void cal (int n1 , int n2) {
        System.out.println((double)n1/n2);
    }
}
