package com._onesafe.singleton;

import java.net.Socket;

/**
 * Created by onesafe on 15/10/2018.
 */
public final class VolatileDoubleCheck {

    private byte[] data = new byte[1024];

    private volatile static VolatileDoubleCheck instance = null;

    private Socket socket;

    private VolatileDoubleCheck() {
        this.socket = new Socket();
    }

    public static VolatileDoubleCheck getInstance() {
        if (null == instance) {
            synchronized (VolatileDoubleCheck.class) {
                if (null == instance) {
                    instance = new VolatileDoubleCheck();
                }
            }
        }
        return instance;
    }
}
