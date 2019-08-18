package annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ParseAnno {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("annotation.Student");

            // 获取类的所有注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            // 获得类指定的注解
            WypTable wt = (WypTable) clazz.getAnnotation(WypTable.class);
            System.out.println(wt.value());

            // 获得类的属性的注解
            Field f = clazz.getDeclaredField("name");
            WypField wf = f.getAnnotation(WypField.class);
            System.out.println(wf.columnName() + "--" + wf.type() + "--" + wf.length());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
