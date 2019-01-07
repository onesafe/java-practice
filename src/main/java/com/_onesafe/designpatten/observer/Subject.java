package com._onesafe.designpatten.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> list = new ArrayList<Observer>();

    public void register(Observer obs) {
        list.add(obs);
    }

    public void removeObserver(Observer obs) {
        list.remove(obs);
    }

    // 通知所有的观察者更新状态
    public void notifyAllObserver() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}
