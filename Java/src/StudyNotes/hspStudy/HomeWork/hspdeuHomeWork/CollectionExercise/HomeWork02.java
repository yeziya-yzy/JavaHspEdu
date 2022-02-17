package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.CollectionExercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        for( int i = 0;i<=9;i++){
            list.add(i+"");
        }
        System.out.println(list);
        list.add(2,"HSPEDU");
        System.out.println(list.get(5));
        list.remove(6);
        list.set(7,"HSp");
        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
    }
}
