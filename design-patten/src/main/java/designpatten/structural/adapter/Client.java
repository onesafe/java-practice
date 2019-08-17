package designpatten.structural.adapter;


/**
 * 客户端类
 */
public class Client {

    private void test1(Target t) {
        t.handleReq();
    }

    public static void main(String[] args) {
        Client c = new Client();
        Target t = new Adapter();
        c.test1(t);


        Client c2 = new Client();
        Adaptee a = new Adaptee();
        Target t2 = new Adapter2(a);
        c2.test1(t2);
    }
}
