package 案例.HomeWork.hspdeuHomeWork.CollectionExercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add(new Dog("jack",6));
        list1.add(new Dog("tom",9));
        list1.add(new Dog("mack",2));


        System.out.println("======下面是迭代器=======");
        Iterator i1 = list1.iterator();
        while (i1.hasNext()) {
            Object obj =  i1.next();
            System.out.println(obj);
        }

        System.out.println("======下面是增强for循环=======");

        for (Object o :list1) {
            System.out.println(o);
        }

    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}