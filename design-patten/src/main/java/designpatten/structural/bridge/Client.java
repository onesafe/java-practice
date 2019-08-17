package designpatten.structural.bridge;

public class Client {

    public static void main(String[] args) {
        Computer c = new Laptop(new Lenovo());
        c.sale();

        Computer c2 = new Desktop(new Shenzhou());
        c2.sale();
    }
}
