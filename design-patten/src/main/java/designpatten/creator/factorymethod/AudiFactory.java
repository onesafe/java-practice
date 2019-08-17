package designpatten.creator.factorymethod;

public class AudiFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Audi();
    }
}
