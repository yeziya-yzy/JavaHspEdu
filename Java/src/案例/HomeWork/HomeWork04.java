package 案例.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */
public class HomeWork04 {
    public static void main(String[] args) {
        new A().f1();
    }
}

class A {

    private String NAME = "1";

    public void f1 (){
        class B {
            private final String NAME = "2";
            public void show(){
                System.out.println(NAME);
                System.out.println(A.this.NAME);
            }
        }
        new B().show();
    }
}