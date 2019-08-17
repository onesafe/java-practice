package designpatten.creator.factorymethod;

public class BydFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Byd();
    }
}
