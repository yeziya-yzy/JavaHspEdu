package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.AggregateHomeWork;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);
        m.put("jack", 2600);
        System.out.println(m);
        Set set = m.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            Map.Entry o1 = (Map.Entry) o;
            o1.setValue((int) o1.getValue() + 100);
            System.out.println(o1.getKey() + "\t" + o1.getValue());
        }
        System.out.println(m);
    }
}