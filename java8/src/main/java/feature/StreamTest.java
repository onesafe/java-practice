package feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by onesafe on 30/08/2019 3:04 PM.
 */
public class StreamTest {


    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // Filter
        stringCollection
                .stream()
                .filter((s -> s.startsWith("a"))) // Filter 的入参是一个 Predicate
                .forEach(System.out::println);  // foreach 是一个终端操作，它的返参是 void, 我们无法对其再次进行流操作。


        // Sorted
        stringCollection
                .stream()
                .sorted() // sorted 不会对 stringCollection 做出任何改变
                .filter((s -> s.startsWith("a")))
                .forEach(System.out::println);

        // Map
        stringCollection
                .stream()
                .map(String::toUpperCase) // 中间操作 Map 能够帮助我们将 List 中的每一个元素做功能处理
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // Match
        // 验证 list 中 string 是否有以 a 开头的, 匹配到第一个，即返回 true
        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        // 验证 list 中 string 是否都是以 a 开头的
        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        // 验证 list 中 string 是否都不是以 z 开头的,
        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // Count
        // 先对 list 中字符串开头为 b 进行过滤，让后统计数量
        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3


        // Reduce
        Optional<String> reduced = stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }
}
