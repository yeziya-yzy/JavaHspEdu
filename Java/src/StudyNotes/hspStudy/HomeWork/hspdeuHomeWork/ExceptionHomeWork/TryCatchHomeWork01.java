package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.ExceptionHomeWork;

import java.util.Scanner;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class TryCatchHomeWork01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        String inputString = "";
        while (true){
            System.out.print("请输入一个整数");
            inputString = scanner.next();
            try {
                input = Integer.parseInt(inputString);
                break;
            }catch (Exception e) {
                System.out.println("请输入一个整数");
            }
        }
        System.out.println("输入的数是"+input);
    }
}