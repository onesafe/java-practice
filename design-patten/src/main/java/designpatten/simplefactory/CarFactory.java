package designpatten.simplefactory;

public class CarFactory {

    public static Car createAudi() {
        return new Audi();
    }

    public static Car createByd() {
        return new Byd();
    }
}
