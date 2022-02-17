package 案例.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        Frock frock3 = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock1.getNextNum());
        System.out.println(frock2.getNextNum());
        System.out.println(frock3.getNextNum());
    }
}
class Frock {
    private int serialNumber;
     static int currentNum = 100000;

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum(){
        currentNum += 100;
        return  currentNum;
    }
}