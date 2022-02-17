package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.SetHomeWork;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HashMapHomeWork {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new Employee3(1, "wyw", 20000));
        hashMap.put(2, new Employee3(2, "qqq", 19000));
        hashMap.put(3, new Employee3(3, "eee", 12000));
        Set set = hashMap.keySet();
        for (Object key : set) {
            System.out.println(key + " " + hashMap.get(key));
            Employee3 employee = (Employee3) hashMap.get(key);
            if (employee.getSal() > 18000) {
                System.out.println(key + employee.getName());
            }
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "" + hashMap.get(key));
        }

        Set entrySet = hashMap.entrySet();
        for (Object entry : entrySet) {
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey() + "" + entry1.getValue());
        }
    }
}

class Employee3 {
    private int id;
    private String name;
    private double sal;

    public Employee3(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return "Employee3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}