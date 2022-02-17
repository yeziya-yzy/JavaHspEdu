package StudyNotes.hspStudy.Threadedu.HomeWork;

import java.util.Scanner;

/**
 * @coding: utf-8
 * 1.在main方法中启动两个线程
 * 2.第一题个线程循环随机打印100以内的整数
 * 3.直到第二个线程从键盘读取了"Q"命令
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        second_Thread thread = new second_Thread();
        new first_Thread(thread).start();
        thread.start();
    }
}

class first_Thread extends Thread {
    private second_Thread st = null;

    public first_Thread(second_Thread st) {
        this.st = st;
    }

    @Override
    public void run() {
        while (!(st.control)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((int) (Math.random() * 100) + 1);
        }

    }
}

class second_Thread extends Thread {
    boolean control = false;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (!control) {
            System.out.print("正在等待键盘输入:");
            String next = scanner.next();
            if (next.charAt(0) == 'Q') {
                control = true;
            }
        }
    }
}