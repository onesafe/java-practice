package feature;

/**
 * Created by onesafe on 30/08/2019 2:08 PM.
 */
public class FuncInteTest {

    // 静态变量
    static int outerStaticNum;

    // 成员变量
    int outerNum;

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);

        Integer converted = converter.convert("123");
        System.out.println(converted);


        // lambda 表达式更简洁的方式： 方法引用
        Converter<String, Integer> converter1 = Integer::valueOf;


        // 访问局部变量, final类型，可以隐式
        final int num = 1;
        Converter<Integer, String> stringConverter = (from -> String.valueOf(from + num));
        stringConverter.convert(2);


        // 访问静态变量, 成员变量不可以访问
        Converter<Integer, String> stringConverter1 = (from -> {outerStaticNum = 72; return String.valueOf(from);});


        // 带有默认实现的接口方法，是不能在lambda表达式中访问的。

    }
}
