package designpatten.actor.observer;


import lombok.Data;

@Data
public class ConcreteSubject extends Subject {

    private int state;

    public void setState(int state) {
        this.state = state;
        // 目标对象值发生了变化，请通知所有的观察者
        this.notifyAllObserver();
    }
}
