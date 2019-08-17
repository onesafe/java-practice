package designpatten.creator.builder;

public class OnesafeShipBuilder implements AirShipBuilder {

    @Override
    public Engine builderEngine() {
        System.out.println("构建onesafe牌发动机");
        return new Engine("构建onesafe牌发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建onesafe牌轨道仓");
        return new OrbitalModule("构建onesafe牌轨道仓");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建onesafe牌逃逸塔");
        return new EscapeTower("构建onesafe牌逃逸塔");
    }
}
