package StudyNotes.hspStudy.reflection.HomeWork;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @coding: utf-8
 * 要求：
 * 1.定义PrivateTest类,有私有name属性,并且属性值为hello kitty
 * 2.提供getName的公有方法
 * 3.创建PrivateTest的类,利用Class类得到私有的name属性,修改私有的name属性值,
 * 并调用getName()的方法打印name属性值
 */
public class HomeWork01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException {
        //创建PrivateTest的Class类对象
        Class<?> testClass = Class.forName("StudyNotes.hspStudy.reflection.HomeWork.PrivateTest");
        //创建实例对象
        Object o = testClass.newInstance();
        //得到name属性对象,注意这里是私有的
        Field name = testClass.getDeclaredField("name");
        //暴破后才能进行修改
        name.setAccessible(true);
        //改值
        name.set(o,"HELLO KITTY");
        //得到getName方法,这里是共有的
        Method getName = testClass.getMethod("getName");
        //调用getName方法(共有的方法,不用暴破,直接使用)
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }
}
class PrivateTest {
    private String name = "hello kitty";

    public String getName() {
        return name;
    }
}