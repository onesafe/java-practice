package feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by onesafe on 30/08/2019 1:49 PM.
 */
public class MyLambda {

    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    private void originalSort() {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }

    // 进化1
    private void lambda1() {
        Collections.sort(names, (String a, String b) -> {
            return (a + 1).compareTo(b);
        });
    }


    // 进化2
    private void lambda2() {
        Collections.sort(names, (String a, String b) -> (a + 1).compareTo(b));
    }


    // 最简洁的使用方式
    private void lambda3() {
        names.sort((a, b) -> (a + 1).compareTo(b));
    }

    public static void main(String[] args) {
        MyLambda myLambda = new MyLambda();
        myLambda.originalSort();
        myLambda.lambda1();
        myLambda.lambda2();
        myLambda.lambda3();
        System.out.println(myLambda.names);
    }
}
