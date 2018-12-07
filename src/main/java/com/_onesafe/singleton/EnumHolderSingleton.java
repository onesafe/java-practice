package com._onesafe.singleton;

/**
 * Created by onesafe on 07/12/2018.
 */
public class EnumHolderSingleton {

    private byte[] data = new byte[1024];

    private EnumHolderSingleton() {

    }

    // 这个和静态内部类的方法很像，只不过把静态内部类改成了内部枚举类而已
    private enum EnumHolder {

        INSTANCE;

        private EnumHolderSingleton instance;

        EnumHolder() {
            this.instance = new EnumHolderSingleton();
        }

        private EnumHolderSingleton getSingleton() {
            return instance;
        }
    }

    public static EnumHolderSingleton getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }
}
