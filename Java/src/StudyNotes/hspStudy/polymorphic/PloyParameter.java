package StudyNotes.hspStudy.polymorphic;

public class PloyParameter {
    public static void main(String[] args) {
        Worker ym = new Worker("ym", 5000);
        Master wyw = new Master("wyw", 10000, 200000);
        PloyParameter ployParameter = new PloyParameter();
        ployParameter.showEmpAnnual(ym);
        ployParameter.showEmpAnnual(wyw);
    }
    public void showEmpAnnual(Employee e){
        e.getAnnual();
        if (e instanceof Worker){
            Worker worker = (Worker)e;
            worker.work();
        }else if (e instanceof Master){
            Master master = (Master)e;
            master.manage();
        }
    }
}

class Employee {
    private String name;
    private double sal;

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
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
    public void getAnnual(){
        System.out.println("name= "+ name +" sal= " + sal);
    }
}

class Worker extends Employee{

    public Worker(String name, double sal) {
        super(name, sal);
    }

    public void work(){
        System.out.println("name="+getName()+"正在工作");
    }

    @Override
    public void getAnnual() {
        System.out.println("name="+getName()+" sal="+getSal()*12);
    }
}

class Master extends Employee{
    private double bonus;

    public Master(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void getAnnual() {
        System.out.println("name="+getName()+" sal="+(super.getSal()*12+bonus));
    }
    public void manage(){
        System.out.println("name="+getName()+"正在管理");
    }
}