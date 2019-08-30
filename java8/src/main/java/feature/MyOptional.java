package feature;

import java.util.Optional;

/**
 * Created by onesafe on 30/08/2019 2:58 PM.
 */
public class MyOptional {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();

        optional.get();

        optional.orElse("fallback");

        optional.ifPresent((s -> System.out.println(s.charAt(0))));
    }
}
