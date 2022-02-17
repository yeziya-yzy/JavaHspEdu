package StudyNotes.hspStudy.FileEdu.HomeWork;

import java.io.*;
import java.util.Properties;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\ConfigurationFile\\dog.properties"));

        //读取
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        //序列化
        String path = "F:\\Java_Learn\\测试目录\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeUTF(name);
        oos.writeInt(age);
        oos.writeUTF(color);
        oos.writeObject(dog);
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        System.out.println(ois.readUTF());
        System.out.println(ois.readInt());
        System.out.println(ois.readUTF());
        Dog o = (Dog)ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
class Dog implements Serializable{//可序列化
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
