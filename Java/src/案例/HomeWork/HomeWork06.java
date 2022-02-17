package 案例.HomeWork;

/**
 * coding: utf-8
 * @version 1.0
 */
public class HomeWork06 {
    public static void main(String[] args) {
        Car car = new Car(50);
        car.returnAir().flow();
    }
}
class Car {
    private int temperature = 0;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow(){
            if (temperature > 40){
                System.out.println("PutCool");
            }else if ( temperature < 0){
                System.out.println("PutHot");
            }else {
                System.out.println("====");
            }
        }
    }

    public Air returnAir(){
        return new Air();
    }
}