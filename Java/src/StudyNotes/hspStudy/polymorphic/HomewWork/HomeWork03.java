package StudyNotes.hspStudy.polymorphic.HomewWork;

public class HomeWork03 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("wyw1", 20, "讲师1", 4000);
        System.out.println(teacher.introduce());
        Teacher teacher2 = new professor("wyw2", 20, "讲师2", 3000);
        System.out.println(teacher2.introduce());
        Teacher teacher3 = new aprofessor("wyw3", 20, "讲师3", 2000);
        System.out.println(teacher3.introduce());
        Teacher teacher4 = new lecturer("wyw4", 20, "讲师4", 1000);
        System.out.println(teacher4.introduce());
    }
}

class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }
    public String info(){
        return "name="+getName()+"\tage="+getAge()+"\tpost="+getPost()+"\tsalary=";
    }
    public String introduce(){
        return this.info()+getSalary();
    }
}

class professor extends Teacher{
    public professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }
    public String introduce(){
        return super.info()+getSalary()*1.3;
    }
}

class aprofessor extends Teacher{
    public aprofessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }
    public String introduce(){
        return super.info()+getSalary()*1.2;
    }
}

class lecturer extends Teacher{
    public lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }
    public String introduce(){
        return super.info()+getSalary()*1.1;
    }
}