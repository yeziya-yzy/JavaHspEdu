package StudyNotes.hspStudy.polymorphic.HomewWork;

public class HomeWork04 {
    public static void main(String[] args) {
        manager wyw = new manager("wyw", 30, 120,1.2);
        normalStaff zzc = new normalStaff("zzc", 10, 70);
        wyw.infosalary();
        zzc.infosalary();
    }
}

//定义员工类
class staff{
    private String name;
    private int day;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public staff(String name, int day, double salary) {
        this.name = name;
        this.day = day;
        this.salary = salary;
    }

    public void infosalary(){
        System.out.println("name="+name+" day="+day+" salary="+salary);
    }
}

class manager extends staff{
    private double grade;

    public manager(String name, int day, double salary, double grade) {
        super(name, day, salary);
        this.grade = grade;
    }

    public void infosalary(){
        System.out.println("name="+getName()+" day="+getDay()+" salary="+getDay()*getSalary()*grade);
    }
}

class normalStaff extends staff{
    public normalStaff(String name, int day, double salary) {
        super(name, day, salary);
    }
    public void infosalary(){
        System.out.println("name="+getName()+" day="+getDay()+" salary="+getDay()*getSalary());
    }
}