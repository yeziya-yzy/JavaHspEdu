package StudyNotes.hspStudy.Threadedu;

/**
 * coding: utf-8
 * 使用继承Thread来实现多线程
 *
 * @version 1.0
 */
public class UseThread {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();//新线程的开始
        for (int i = 0; i < 10; i++) {//新线程并不影响后面代码的实现
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是main" + (i + 1) + Thread.currentThread().getName());
        }

    }
}

class Cat extends Thread {
    int count = 0;

    @Override
    public void run() {//重写run方法,实现自己的业务逻辑
        while (true) {
            System.out.println("喵喵" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}