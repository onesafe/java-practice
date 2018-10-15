package com._onesafe.singleton;

/**
 * Created by onesafe on 15/10/2018.
 */
public class Lanhan {
    private byte[] data = new byte[1024];

    private static Lanhan instance = null;

    private Lanhan() {

    }

    public static synchronized Lanhan getInstance() {
        if (null == instance) {
            instance = new Lanhan();
        }
        return instance;
    }
}
