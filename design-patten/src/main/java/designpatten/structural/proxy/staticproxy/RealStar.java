package designpatten.structural.proxy.staticproxy;

public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.singContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing()");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}
