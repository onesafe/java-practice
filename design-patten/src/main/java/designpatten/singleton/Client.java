package designpatten.singleton;

public class Client {
    public static void main(String[] args) {
        testEhanSingleton();
        testLanhanSingleton();
        testInnerClassSingleton();
        testEnumSingleton();
    }

    private static void testEhanSingleton() {
        EhanSingleton e1 = EhanSingleton.getInstance();
        EhanSingleton e2 = EhanSingleton.getInstance();
        System.out.println(e1);
        System.out.println(e2);
    }

    private static void testLanhanSingleton() {
        LanhanSingleton l1 = LanhanSingleton.getInstance();
        LanhanSingleton l2 = LanhanSingleton.getInstance();
        System.out.println(l1);
        System.out.println(l2);
    }

    private static void testInnerClassSingleton() {
        InnerClassSingleton i1 = InnerClassSingleton.getInstance();
        InnerClassSingleton i2 = InnerClassSingleton.getInstance();
        System.out.println(i1);
        System.out.println(i2);
    }

    private static void testEnumSingleton() {
        EnumSingleton e1 = EnumSingleton.getInstance();
        EnumSingleton e2 = EnumSingleton.getInstance();
        System.out.println(e1);
        System.out.println(e2);
    }
}
