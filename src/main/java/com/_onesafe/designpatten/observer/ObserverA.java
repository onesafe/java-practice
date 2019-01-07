package com._onesafe.designpatten.observer;


import lombok.Data;

@Data
public class ObserverA implements Observer {

    private int myState;

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

}
