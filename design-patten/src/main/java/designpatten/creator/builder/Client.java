package designpatten.creator.builder;

public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new OnesafeDirector(new OnesafeShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine());
        ship.launch();
    }
}
