package feature;

/**
 * Created by onesafe on 30/08/2019 2:07 PM.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
