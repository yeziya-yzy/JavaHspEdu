package 案例.HomeWork.hspdeuHomeWork.GenericExercise;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class Exercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> Employees= new ArrayList<Employee>();
        Employees.add(new Employee("yj",5000,new MyData(2001,1,1)));
        Employees.add(new Employee("yx",4500,new MyData(2002,2,2)));
        Employees.add(new Employee("zzc",4800,new MyData(2003,3,3)));
        System.out.println("Employees=" + Employees);
        System.out.println("===对室友开始排序===");
        Employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //不比较
                if (!(o1 instanceof Employee && o2 instanceof Employee)){
                    return 0;
                }
                //比较name
                int i = o1.getName().compareTo(o2.getName());
                //i表示名字比的结果
                if (i != 0 ) return i; //两个名字不相同
                //名字相同，开始比生日
                //年-->月-->日相比
                int year =o1.getBirthday().getYear()- o2.getBirthday().getYear();
                if (year != 0 ) return year; //年不相同
                int month =o1.getBirthday().getMonth()- o2.getBirthday().getMonth();
                if (month != 0 ) return year; //月不相同
                return o1.getBirthday().getDay()- o2.getBirthday().getDay();
            }
        });
        System.out.println("Employees=" + Employees);
    }
}
class Employee {
    private String name;
    private double sal;
    private MyData birthday;

    public Employee(String name, double sal, MyData birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
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

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyData getBirthday() {
        return birthday;
    }

    public void setBirthday(MyData birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
class  MyData {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyData(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}