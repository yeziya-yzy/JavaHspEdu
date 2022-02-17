package StudyNotes.hspStudy.Threadedu.HomeWork;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork02 {
    public static void main(String[] args) {
        User user = new User();
        Thread thread1 = new Thread(user);
        Thread thread2 = new Thread(user);
        thread1.start();
        thread2.start();
    }
}

class User implements Runnable {
    static double card = 5000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (card >= 1000) {
                    card -= 1000;
                    System.out.println(Thread.currentThread().getName()+"取出1000现在还有 "+ card);
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}