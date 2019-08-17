package designpatten.singleton;

import java.lang.reflect.Constructor;

public class CrackClient {

    public static void main(String[] args) throws Exception {
        testLanhan();
    }

    @SuppressWarnings("unchecked")
    private static void testLanhan() throws Exception {
        LanhanSingleton l1 = LanhanSingleton.getInstance();
        LanhanSingleton l2 = LanhanSingleton.getInstance();

        System.out.println(l1);
        System.out.println(l2);

        // 通过反射的方式直接调用私有构造器
        Class<LanhanSingleton> clazz = (Class<LanhanSingleton>) Class.forName("designpatten.singleton.LanhanSingleton");
        Constructor<LanhanSingleton> c = clazz.getDeclaredConstructor();
        c.setAccessible(true);

        LanhanSingleton l3 = c.newInstance();
        LanhanSingleton l4 = c.newInstance();
        System.out.println(l3);
        System.out.println(l4);
    }
}
