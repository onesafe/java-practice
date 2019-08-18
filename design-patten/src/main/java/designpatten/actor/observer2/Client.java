package designpatten.actor.observer2;

/**
 * 258952499
 * 603742814
 * 1067040082
 * 3
 * 100
 * 100
 * 100
 * 500
 * 500
 * 500
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ObserverA ob1 = new ObserverA();
        ObserverA ob2 = new ObserverA();
        ObserverA ob3 = new ObserverA();

        subject.addObserver(ob1);
        subject.addObserver(ob2);
        subject.addObserver(ob3);

        System.out.println(ob1.hashCode());
        System.out.println(ob2.hashCode());
        System.out.println(ob3.hashCode());

        System.out.println(subject.countObservers());

        subject.setState(100);

        System.out.println(ob1.getMyState());
        System.out.println(ob2.getMyState());
        System.out.println(ob3.getMyState());

        subject.setState(500);

        System.out.println(ob1.getMyState());
        System.out.println(ob2.getMyState());
        System.out.println(ob3.getMyState());
    }
}

