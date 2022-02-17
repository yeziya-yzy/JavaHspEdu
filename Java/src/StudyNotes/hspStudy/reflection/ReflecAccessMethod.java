package StudyNotes.hspStudy.reflection;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @coding: utf-8
 * 演示通过反射调用方法
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1. 得到 Student 类对应的 Class 对象
        Class<?> stuClass = Class.forName("StudyNotes.hspStudy.reflection.Student2");
        //2. 创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是 Student
        System.out.println(o.getClass());//Student
        //3. 使用反射得到 age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);//通过反射来操作属性
        System.out.println(o);//
        System.out.println(age.get(o));//返回 age 属性的值
        //4. 使用反射操作 name 属性
        Field name = stuClass.getDeclaredField("name");
        //对 name 进行暴破, 可以操作 private 属性
        name.setAccessible(true);
        //name.set(o, "老韩");
        name.set(null, "老韩~");//因为 name 是 static 属性，因此 o 也可以写出 null
        System.out.println(o);
        System.out.println(name.get(o)); //获取属性值
        System.out.println(name.get(null));//获取属性值, 要求 name 是 static
    }
}

class Student2 {
    public int age;
    private static String name;

    public Student2() {
    }

    public String toString() {
        return "Student[age=+" + age + ",name" + name + "]";
    }
}