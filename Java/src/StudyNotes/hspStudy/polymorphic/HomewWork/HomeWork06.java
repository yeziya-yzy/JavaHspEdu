package StudyNotes.hspStudy.polymorphic.HomewWork;

import java.util.Objects;

public class HomeWork06 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("wyw", 20, "S", '男', 10000);
        Doctor doctor2 = new Doctor("qll", 20, "mn", '女', 10000);
        System.out.println(doctor.equals(doctor2));
    }
}
class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if ( this==null || obj==null ) return false;
        if ( ! (obj instanceof Doctor)) return false;
        Doctor doctor = (Doctor)obj;
        return this.age == doctor.age &&
               this.gender == doctor.gender &&
               this.sal == doctor.sal &&
               Objects.equals(this.job,doctor.job) &&
               Objects.equals(this.name,doctor.name);
    }
}