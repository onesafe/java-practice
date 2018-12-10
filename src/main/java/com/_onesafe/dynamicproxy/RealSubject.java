package com._onesafe.dynamicproxy;

/**
 * Created by onesafe on 10/12/2018.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("Hello: " + str);
    }
}
