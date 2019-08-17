package designpatten.singleton;

/**
 * 饿汉式单例模式
 */
public class EhanSingleton {

    private EhanSingleton() {}

    // 类初始化时，立即加载这个对象，加载类时，天然的线程安全
    private static EhanSingleton instance = new EhanSingleton();

    // 方法没有同步，调用效率高
    public static EhanSingleton getInstance() {
        return instance;
    }
}
