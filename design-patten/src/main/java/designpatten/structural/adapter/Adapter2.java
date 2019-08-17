package designpatten.structural.adapter;

/**
 * 适配器本身 （对象适配器）
 * 组合的方式
 */
public class Adapter2 implements Target {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
