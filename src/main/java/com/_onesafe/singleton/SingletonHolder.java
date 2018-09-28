package com._onesafe.singleton;

/**
 * Created by onesafe on 28/09/2018.
 */
public final class SingletonHolder {
    private byte[] data = new byte[2048];

    private SingletonHolder() {

    }

    private static class Holder {
        private static SingletonHolder instance = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return Holder.instance;
    }
}
