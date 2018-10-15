package com._onesafe.singleton;

/**
 * Created by onesafe on 15/10/2018.
 */
public class Ehan {

    private byte[] data = new byte[1024];

    private static Ehan instance = new Ehan();

    private Ehan() {}

    public static Ehan getInstance() {
        return instance;
    }
}
