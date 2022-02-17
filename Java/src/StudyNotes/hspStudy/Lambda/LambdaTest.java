package StudyNotes.hspStudy.Lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable r1");
            }
        };
        r1.run();
        System.out.println("==================");
        Runnable r2 = () -> System.out.println("Runnable r2");
        r2.run();
    }


    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
                //相当于o1-o2 只是小于零的都变成-1，Integer.compare(o1,o2)只表示大小，不表示大多少
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("==========================");
        Comparator<Integer> com2 = (Integer o1, Integer o2) -> {return Integer.compare(o1,o2);};
        int compare2 = com1.compare(12, 21);
        System.out.println(compare2);
    }
}
