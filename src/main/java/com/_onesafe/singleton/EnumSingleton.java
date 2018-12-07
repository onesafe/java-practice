package com._onesafe.singleton;

/**
 * Created by onesafe on 07/12/2018.
 */
public enum EnumSingleton {

    INSTANCE;

    private byte[] data = new byte[1024];

    EnumSingleton() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void testMethod() {
        System.out.println("i am test method");
    }

    // INSTANCE 实例的方法
    public void getName() {
        System.out.println("my name is onesafe");
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
