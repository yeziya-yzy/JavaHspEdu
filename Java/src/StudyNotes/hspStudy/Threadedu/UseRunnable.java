package StudyNotes.hspStudy.Threadedu;

/**
 * coding: utf-8
 * 使用Runnable完成多线程
 * @version 1.0
 */
public class UseRunnable {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //由于Runnable接口没有start()方法,要用其他办法了
        Thread thread = new Thread(dog);
        thread.start();
//        dog.start();
    }
}

class Dog implements Runnable {
    int count = 0;
    @Override
    public void run() {//重写run方法,实现自己的业务逻辑
        while (true) {
            System.out.println("汪汪" + (++count) + Thread.currentThread().getName());
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
//    public static void start(){
//        Thread thread = new Thread(new Dog());
//        thread.start();
//    }
}