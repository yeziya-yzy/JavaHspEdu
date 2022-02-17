package StudyNotes.hspStudy.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class introduce {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //根据配置文件 reflection.properties 指定信息, 创建 Cat 对象并调用方法 hi
        //老韩回忆
        //传统的方式 new 对象 -》 调用方法
        // Cat cat = new Cat();
        // cat.hi(); ===> cat.cry() 修改源码. //我们尝试做一做 -> 明白反射
        //1. 使用 Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\ConfigurationFile\\reflection.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"StudyNotes.hspStudy.reflection.test1"
        String methodName = properties.get("method").toString();//"hi"
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + methodName);
        //2. 创建对象 , 传统的方法，行不通 =》 反射机制
        //new classfullpath();这样子是不行的，但是我们想创建一个new StudyNotes.hspStudy.reflection.test1，传统方法我们没办法
        //3. 使用反射机制解决
        //(1) 加载类, 返回 Class 类型的对象 cls
        Class<?> cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 StudyNotes.hspStudy.reflection.test1 的对象实例
        Object o = cls.newInstance();
        System.out.println("o 的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 StudyNotes.hspStudy.reflection.test1 的 methodName"hi" 的方法对象
        // 即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过 method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)
    }
}
