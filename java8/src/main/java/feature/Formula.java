package feature;

/**
 * Created by onesafe on 30/08/2019 1:41 PM.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
