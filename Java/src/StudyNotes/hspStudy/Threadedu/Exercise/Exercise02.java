package StudyNotes.hspStudy.Threadedu.Exercise;

/**
 * coding: utf-8
 * @version 1.0
 */
public class Exercise02 {
    public static void main(String[] args)  throws InterruptedException{
        int count = 0;
        H3 h3 = new H3();
        Thread thread = new Thread(h3);
        while (true) {
            System.out.println("Hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                thread.start();
                thread.join();
            }

            if (count == 10){
                break;
            }
        }
    }
}

class H3 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello "+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10){
                break;
            }
        }
    }
}