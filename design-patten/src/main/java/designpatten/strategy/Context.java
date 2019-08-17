package designpatten.strategy;

/*
 负责和具体的策略交互
 这样的话，具体的算法和直接的客户端分离了，使得算法可以独立于客户端独立的变化
 */
public class Context {
    private Strategy strategy; //当前采用的算法

    // 通过构造器来注入
    public Context(Strategy strategy) {
        super();
        this.strategy = strategy;
    }

    public void printPrice(double s) {
        System.out.println("您该报价： " + strategy.getPrice(s));
    }
}
