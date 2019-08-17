package designpatten.structural.adapter;

/**
 * 适配器本身 （类适配器）
 * 继承的方式
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void handleReq() {
        super.request();
    }
}
