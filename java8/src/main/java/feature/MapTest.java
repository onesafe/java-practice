package feature;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onesafe on 30/08/2019 3:26 PM.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i=0; i<10; i++) {
            // 与老版不同的是，putIfAbent() 方法在 put 之前，
            // 会判断 key 是否已经存在，存在则直接返回 value, 否则 put, 再返回 value
            map.putIfAbsent(i, "val" + i);
        }

        // forEach 可以很方便地对 map 进行遍历操作
        map.forEach((key, value) -> System.out.println(key + ", " + value));


        // computeIfPresent(), 当 key 存在时，才会做相关处理
        // 如下：对 key 为 3 的值，内部会先判断值是否存在，存在，则做 value + key 的拼接操作
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33


        // 先判断 key 为 9 的元素是否存在，存在，则做删除操作
        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        // computeIfAbsent(), 当 key 不存在时，才会做相关处理
        // 如下：先判断 key 为 23 的元素是否存在，不存在，则添加
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        // 先判断 key 为 3 的元素是否存在，存在，则不做任何处理
        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33



        // 只有当给定的 key 和 value 完全匹配时，才会执行删除操作。
        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null


        // 若 key 42 不存在，则返回 not found
        map.getOrDefault(42, "not found");  // not found


        // merge 方法，会先判断进行合并的 key 是否存在，不存在，则会添加元素
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9

        // 若 key 的元素存在，则对 value 执行拼接操作
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
    }
}
