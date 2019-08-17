package designpatten.creator.builder;

public class OnesafeDirector implements AirShipDirector {

    private AirShipBuilder builder;

    public OnesafeDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine e = builder.builderEngine();
        OrbitalModule o = builder.builderOrbitalModule();
        EscapeTower escapeTower = builder.builderEscapeTower();

        AirShip ship = new AirShip();
        ship.setEngine(e);
        ship.setEscapeTower(escapeTower);
        ship.setOrbitalModule(o);
        return ship;
    }
}
