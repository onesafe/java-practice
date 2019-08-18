package designpatten.structural.decorator;

/**
 * 抽象构建对象
 */
public interface ICar {
    void move();
}

// 具体构建
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
}

// 装饰角色
class SuperCar implements ICar {

    private ICar iCar;

    public SuperCar(ICar iCar) {
        super();
        this.iCar = iCar;
    }

    @Override
    public void move() {
        iCar.move();
    }
}

// 具体装饰对象
class FlyCar extends SuperCar {

    public FlyCar(ICar iCar) {
        super(iCar);
    }

    public void fly() {
        System.out.println("天上飞!");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

// 具体装饰对象
class WaterCar extends SuperCar {

    public WaterCar(ICar iCar) {
        super(iCar);
    }

    public void water() {
        System.out.println("水里游!");
    }

    @Override
    public void move() {
        super.move();
        water();
    }
}


// 具体装饰对象
class AICar extends SuperCar {

    public AICar(ICar iCar) {
        super(iCar);
    }

    public void auto() {
        System.out.println("自动跑!");
    }

    @Override
    public void move() {
        super.move();
        auto();
    }
}
