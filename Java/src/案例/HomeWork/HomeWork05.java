package 案例.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */

public class HomeWork05 {
    public static void main(String[] args) {
        Vehicles vehicles = new Horse();
        Vehicles vehicles1 = new Boat();
        Person person = new Person("唐僧",vehicles);
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("使用Horse");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("使用Boat");
    }
}

class VehiclesFactory {
    public static Horse HorseGet() {
        return new Horse();
    }

    public static Boat BoatGet() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        Boat boat = VehiclesFactory.BoatGet();
        boat.work();
    }

    public void common() {
        Horse horse = VehiclesFactory.HorseGet();
        horse.work();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }
}