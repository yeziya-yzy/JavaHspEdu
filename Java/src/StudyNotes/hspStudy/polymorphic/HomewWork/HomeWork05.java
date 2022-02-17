package StudyNotes.hspStudy.polymorphic.HomewWork;

public class HomeWork05 {
    public static void main(String[] args) {
        Worker worker = new Worker(40000);
        worker.printSalary();
        Peasant peasant = new Peasant(30000);
        peasant.printSalary();
        Waiter waiter = new Waiter(35000);
        waiter.printSalary();
        Teacher2 teacher2 = new Teacher2(100000,200,20);
        teacher2.printSalary();
        Scientist scientist = new Scientist(120000, 50000);
        scientist.printSalary();
    }
}
class Employee{
    private int salary;
    private int salMonth = 12;
    public Employee(int salary) {
        this.salary = salary;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void printSalary(){
        System.out.println("salary="+salary);
    }
}
class Worker extends Employee{
    public Worker(int salary) {
        super(salary);
    }
    public void printSalary(){
        System.out.println("-------工人的工资情况如下-------");
        System.out.println("salary="+getSalary()*getSalMonth());
    }
}
class Peasant extends Employee{
    public Peasant(int salary) {
        super(salary);
    }
    public void printSalary(){
        System.out.println("-------农名的工资情况如下-------");
        System.out.println("salary="+getSalary()*getSalMonth());
    }
}
class Waiter extends Employee{
    public Waiter(int salary) {
        super(salary);
    }
    public void printSalary(){
        System.out.println("-------服务生的工资情况如下-------");
        System.out.println("salary="+getSalary()*getSalMonth());
    }
}
class Teacher2 extends Employee{
    private double classPay;
    private int classDay;
    public Teacher2(int salary,int classDay, double classPay) {
        super(salary);
        this.classDay = classDay;
        this.classPay = classPay;
    }
    public void printSalary(){
        System.out.println("-------老师的工资情况如下-------");
        System.out.println("salary="+(getSalary()*getSalMonth()+classPay*classDay));
    }
}
class Scientist extends Employee{
    private double bonus;

    public Scientist(int salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }
    public void printSalary(){
        System.out.println("-------科学教的工资情况如下-------");
        System.out.println("salary="+(getSalary()*getSalMonth()+bonus));
    }
}