package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by onesafe on 30/08/2019 4:35 PM.
 * FlatMap 能够将流的每个元素, 转换为其他对象的流。
 * 因此，每个对象可以被转换为零个，一个或多个其他对象，并以流的方式返回。之后，这些流的内容会被放入flatMap返回的流中。
 */
public class FlatMapTest {
    static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();

        // 创建 foos 集合
        IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

        // 创建 bars 集合
        foos.forEach(f -> IntStream.range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));


        // 将三个 foo对象的流转换为九个bar对象的流。
        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));




        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);
    }

    static class Outer {
        Nested nested;
    }

    static class Nested {
        Inner inner;
    }

    static class Inner {
        String foo;
    }
}
