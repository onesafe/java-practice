package designpatten.singleton;

/**
 * 懒汉式单例模式
 * 延迟加载，真正用到的时候才加载
 */
public class LanhanSingleton {

    private LanhanSingleton() {}

    private static volatile LanhanSingleton instance = null;

    public static LanhanSingleton getInstance() {
        if (null == instance) {
            synchronized (LanhanSingleton.class) {
                if (null == instance) {
                    instance = new LanhanSingleton();
                }
            }
        }
        return instance;
    }
}
