package StudyNotes.hspStudy.reflection;

import java.util.Scanner;

/**
 * @version 1.0
 * @coding: utf-8
 * 这个是给反射用的类
 */
public class test1 {
    public int age = 21;
    public String name ="my";
    public String brand = "宝马";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathDown = scanner.next();
        String path;
        System.out.println("E:\\桌面" + "\\" + pathDown);
    }
    public void m1(){
        System.out.println("学习笔记.test.test1.m1");
    }

    public test1(String name) {
        this.name = name;
    }

    public test1() {
    }
}