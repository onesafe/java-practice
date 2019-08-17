package designpatten.singleton;

/**
 * 使用枚举类来实现单例模式
 */
public class EnumSingleton {

    private EnumSingleton() {}

    public static EnumSingleton getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }

    private enum EnumHolder {

        INSTANCE;

        private EnumSingleton instance;

        EnumHolder() {
            instance = new EnumSingleton();
        }

        private EnumSingleton getInstance() {
            return instance;
        }
    }
}
