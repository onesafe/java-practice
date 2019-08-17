package designpatten.creator.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 懒汉模式，内部类实现
 */
public class InnerClassSingleton {
    public List<String> list = null;

    private InnerClassSingleton() {
        list = new ArrayList<>();
    }

    public static InnerClassSingleton getInstance() {
        return InnerHolder.instance;
    }

    // 内部类实现
    private static class InnerHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
}
