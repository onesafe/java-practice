package json;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;

/**
 * Object checking utilities.
 */
@SuppressWarnings("unused")
public class CheckUtils {

    public static void checkStringsNotBlank(String... strings) {
        for (String string : strings) {
            if (StringUtils.isBlank(string)) {
                throw new IllegalArgumentException("contains blank string");
            }
        }
    }

    public static void checkObjectsNotNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                throw new IllegalArgumentException("contains null object");
            }
        }
    }

    public static void checkIntsNotNegative(int... numbers) {
        checkIntsLowerBound(0, numbers);
    }

    public static void checkIntsPositive(int... numbers) {
        checkIntsLowerBound(1, numbers);
    }

    public static void checkIntsLowerBound(int min, int... numbers) {
        for (int number : numbers) {
            if (number < min) {
                throw new IllegalArgumentException("contains number smaller than " + min);
            }
        }
    }

    public static void checkIntsUpperBound(int max, int... numbers) {
        for (int number : numbers) {
            if (number > max) {
                throw new IllegalArgumentException("contains number larger than " + max);
            }
        }
    }

    public static void checkLongsNotNegative(long... numbers) {
        checkLongsLowerBound(0, numbers);
    }

    public static void checkLongsPositive(long... numbers) {
        checkLongsLowerBound(1, numbers);
    }

    public static void checkLongsLowerBound(long min, long... numbers) {
        for (long number : numbers) {
            if (number < min) {
                throw new IllegalArgumentException("contains number smaller than " + min);
            }
        }
    }

    public static void checkLongsUpperBound(long max, long... numbers) {
        for (long number : numbers) {
            if (number > max) {
                throw new IllegalArgumentException("contains number larger than " + max);
            }
        }
    }

    public static void checkCollectionContainsNoNull(Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("invalid collection");
        }
        for (Object object : collection) {
            if (object == null) {
                throw new IllegalArgumentException("collection contains null");
            }
        }
    }

    public static void checkCollectionNotEmptyContainsNoNull(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("invalid collection");
        }
        for (Object object : collection) {
            if (object == null) {
                throw new IllegalArgumentException("collection contains null");
            }
        }
    }

}
