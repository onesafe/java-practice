package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by onesafe on 30/08/2019 3:57 PM.
 */
public class StreamTest {

    public static void main(String[] args) {


        Arrays.asList("a1", "a2", "a3")
                .stream() // 创建流
                .findFirst() // 找到第一个元素
                .ifPresent(System.out::println);  // 如果存在，即输出


        // 我们可以通过 Stream.of() 从一堆对象中创建 Stream 流。
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);  // a1



        //除了常规对象流之外，Java 8还附带了一些特殊类型的流，用于处理原始数据类型int，long以及double。
        // 说道这里，你可能已经猜到了它们就是IntStream，LongStream还有DoubleStream。
        IntStream.range(1, 4)
                .forEach(System.out::println); // 相当于 for (int i = 1; i < 4; i++) {}


        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue) // double 类型转 int
                .mapToObj(i -> "a" + i) // 对值拼接前缀 a
                .forEach(System.out::println); // for 循环打印



        // 当且仅当存在终端操作时，中间操作操作才会被执行。



        // 数据流复用问题
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        // 我们可以通过 Supplier 来包装一下流，通过 get() 方法来构建一个新的 Stream 流
        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok



        // 高级操作
        // 构建一个 Person 集合
        List<Person> persons = Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));


        List<Person> filtered = persons
                        .stream() // 构建流
                        .filter(p -> p.name.startsWith("P")) // 过滤出名字以 P 开头的
                        .collect(Collectors.toList()); // 生成一个新的 List

        System.out.println(filtered);    // [Peter, Pamela]


        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age)); // 以年龄为 key,进行分组

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));


        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age)); // 聚合出平均年龄

        System.out.println(averageAge);     // 19.0
    }


    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
