package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.GenericExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class Exercise01 {
    public static void main(String[] args) {
        HashSet<Student> studentSet = new HashSet<Student>();
        Map<String, Student> studentMap = new HashMap<String, Student>();
        studentMap.put("w",new Student("w", 20));
        studentMap.put("y",new Student("y", 23));
        studentMap.put("we",new Student("we", 18));
        studentSet.add(new Student("w", 20));
        studentSet.add(new Student("y", 18));
        studentSet.add(new Student("we", 23));
        for (Student o : studentSet) {
            System.out.println(o);
        }
        Set<Map.Entry<String, Student>> entrySet = studentMap.entrySet();
        for (Map.Entry<String, Student> o : entrySet) {
            System.out.println(o);
        }

    }
}

class Student {
    private String name;
    private int age;

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

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}