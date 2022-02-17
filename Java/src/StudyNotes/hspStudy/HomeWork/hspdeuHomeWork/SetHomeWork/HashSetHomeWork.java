package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.SetHomeWork;

import java.util.HashSet;
import java.util.Objects;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HashSetHomeWork {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("wyw",123));
        hashSet.add(new Employee("wyw",123));
        hashSet.add(new Employee("wyw",1));
        System.out.println(hashSet);
        System.out.println("=================");
        hashSet = new HashSet();
        hashSet.add(new Employee2("wyw",123,new MyData("1","2","3")));
        hashSet.add(new Employee2("wyw",123,new MyData("2","3","4")));
        hashSet.add(new Employee2("wyw",1,new MyData("1","2","3")));
        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return  this.age == employee.age &&
                this.name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Employee2{
    private String name;
    private double sal;
    private MyData birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyData getBirthday() {
        return birthday;
    }

    public void setBirthday(MyData birthday) {
        this.birthday = birthday;
    }

    public Employee2(String name, double sal, MyData birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return name.equals(employee2.name) &&
                birthday.equals(employee2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyData{
    private String year;
    private String month;
    private String day;

    public MyData(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return this.year.equals(myData.year) &&
                this.month.equals(myData.month) &&
                this.day.equals(myData.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}