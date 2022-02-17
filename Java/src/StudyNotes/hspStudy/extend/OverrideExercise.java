package StudyNotes.hspStudy.extend;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("wyw",20);
        Student student = new Student("qll",18,1,100.0);
        System.out.println(person.say());
        System.out.println(student.say());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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

    public String say(){
        return "name:" + this.name + "  age:" + this.age;
    }
}

class Student extends Person {
    private int ID;
    private double score;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, int age, int ID, double score) {
        super(name, age);
        this.ID = ID;
        this.score = score;
    }

    public Student() {
    }

    public String say(){
        return super.say() + "  ID:" + this.ID + "  score:" + this.score;
    }
}