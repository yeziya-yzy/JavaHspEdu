package 案例.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new computer() {
            public void work(int a1, int a2) {
                System.out.println("a1="+a1+"  a2="+a2);
            }
        },123,3213);
    }
}

interface computer {
    public void work(int a1 ,int a2);
}

class CellPhone {
    public void testWork(computer c,int a1 ,int a2) {
        c.work(a1,a2);
    }
}