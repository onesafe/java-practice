package com._onesafe.designpatten.observer2;

import lombok.Data;

import java.util.Observable;


@Data
public class ConcreteSubject extends Observable {

    private int state;

    public void setState(int s) {
        state = s;

        setChanged(); // 表示目标对象已经做了更改
        notifyObservers(); // 通知所有的观察者
    }
}
