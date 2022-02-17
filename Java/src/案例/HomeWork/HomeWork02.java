package 案例.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.shout();
        dog.shout();
    }
}

abstract class Animal {
    public abstract void shout();
}

class Cat extends Animal{

    @Override
    public void shout() {
        System.out.println("Cat shout");
    }
}

class Dog extends Animal{

    @Override
    public void shout() {
        System.out.println("Dog shout");
    }
}