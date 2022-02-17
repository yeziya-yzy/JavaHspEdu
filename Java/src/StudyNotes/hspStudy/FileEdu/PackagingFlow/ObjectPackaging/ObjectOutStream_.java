package StudyNotes.hspStudy.FileEdu.PackagingFlow.ObjectPackaging;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @version 1.0
 * @coding: utf-8
 * 读写要一致
 * implements Serializable
 * static transient这两个不会被序列化
 * 序列化对象时,要求里面属性的类型也需要实现序列化接口
 * 序列化具有可继承性,某类可序列化其所有子类默认实现了可序列化
 * serialVersionUID序列化的版本号,可以提高兼容性(public static final long serialVersionUID = 1L;)
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "F:\\Java_Learn\\测试目录\\ObjectOutStream.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到 e:\data.dat
        oos.writeInt(100);// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("韩顺平教育");//String
        //保存一个 dog 对象
        oos.writeObject(new Dog("旺财", 10, "日本", "白色"));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String country;
    private String color;

    //static transient这两个不会被序列化

    //序列化对象时,要求里面属性的类型也需要实现序列化接口

    //序列化具有可继承性,某类可序列化其所有子类默认实现了可序列化

    //serialVersionUID序列化的版本号,可以提高兼容性
    public static final long serialVersionUID = 1L;

    public Dog(String name, int age, String country, String color) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
