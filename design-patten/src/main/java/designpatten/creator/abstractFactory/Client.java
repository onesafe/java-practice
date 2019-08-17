package designpatten.creator.abstractFactory;

public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCarFactory();
        Engine e = factory.createEngine();
        e.run();
        e.start();

        Seat s = factory.createSeat();
        s.massage();

        Tyre t = factory.createTyre();
        t.revolve();
    }
}
