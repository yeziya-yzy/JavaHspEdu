package StudyNotes.hspStudy.reflection.HomeWork;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @coding: utf-8
 * 要求:
 * 1.利用Class类的forName方法得到File类的class对象
 * 2.在控制台打印File类的所有构造器
 * 3.通过newInstance的方法创建File对象,并创建F:\Java_Learn\测试目录\mynew.txt文件
 */
public class HomeWork02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        String filePath = "F:\\Java_Learn\\测试目录\\mynew.txt";
        //创建Class类对象
        Class<?> FileClass = Class.forName(File.class.getName());//getName()得到全类名
        //得到所有的构造器
        Constructor<?>[] declaredConstructors = FileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //得到其中一个构造器
        Constructor<?> declaredConstructor = FileClass.getDeclaredConstructor(String.class);
        //构造具体对象
        Object file = declaredConstructor.newInstance(filePath);
        //得到createNewFile 的方法对象
        Method createNewFile = FileClass.getMethod("createNewFile");
        //创建文件
        createNewFile.invoke(file);//new File().createNewFile();
        System.out.println("文件创建成功"+filePath);
    }
}