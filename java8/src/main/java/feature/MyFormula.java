package feature;

/**
 * Created by onesafe on 30/08/2019 1:43 PM.
 */
public class MyFormula implements Formula {
    @Override
    public double calculate(int a) {
        return a *2;
    }


    public static void main(String[] args) {
        MyFormula myFormula = new MyFormula();
        double x = myFormula.calculate(3);
        double y = myFormula.sqrt(3);
        System.out.println(x);
        System.out.println(y);
    }
}
