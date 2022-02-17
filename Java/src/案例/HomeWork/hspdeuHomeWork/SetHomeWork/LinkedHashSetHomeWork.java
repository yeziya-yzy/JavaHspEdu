package 案例.HomeWork.hspdeuHomeWork.SetHomeWork;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class LinkedHashSetHomeWork {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("123",123));
        linkedHashSet.add(new Car("123",2123));
        linkedHashSet.add(new Car("123",21223));
        linkedHashSet.add(new Car("123",2123));
        System.out.println(linkedHashSet);
    }
}
class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}