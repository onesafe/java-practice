package generic;

/**
 * Created by onesafe on 04/09/2019 10:25 AM.
 */
public class MultiLimit implements MultiLimitInterfaceA, MultiLimitInterfaceB {

    /**
     * 使用 "&" 符号设定多重边界 (Multi Bounds)
     * @param t t
     * @param <T> <T>泛型类型 T 必须是 MultiLimitInterfaceA 和 MultiLimitInterfaceB 的共有子类型</T>
     */
    public static <T extends MultiLimitInterfaceA & MultiLimitInterfaceB> void test(T t) {

    }
}


/**
 * 接口 A
 */
interface MultiLimitInterfaceA {}

/**
 * 接口 B
 */
interface MultiLimitInterfaceB {}


/*
通常情况下，T，E，K，V，？ 是这样约定的：

    ？ 表示不确定的 java 类型
    T (type) 表示具体的一个java类型
    K V (key value) 分别代表java键值中的Key Value
    E (element) 代表Element
 */