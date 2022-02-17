package StudyNotes.hspStudy.Threadedu.Exercise;

/**
 * coding: utf-8
 * main下面创建两个线程
 * @version 1.0
 */
public class Exercise01 {
    public static void main(String[] args) {
        int count = 0;
        H1 h1 = new H1();
        new Thread(h1).start();
        H2 h2 = new H2();
        new Thread(h2).start();
        while (true){
            System.out.println("这是main  "+(++count)+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count ==10){
                break;
            }
        }
    }
}

class H1 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是H1  " + (++count) + Thread.currentThread().getName());
            if (count ==20){
                break;
            }
        }
    }
}

class H2 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是H2  " + (++count) + Thread.currentThread().getName());
            if (count ==15){
                break;
            }
        }
    }

}