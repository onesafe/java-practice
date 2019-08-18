package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ReflectionInfo {

    public static void main(String[] args) {

        String path = "reflection.User";
        try {
            Class clazz = Class.forName(path);

            // 获取类的名字
            System.out.println(clazz.getName());  //获得包名 + 类名
            System.out.println(clazz.getSimpleName()); //获得类名

            // 获取属性信息
            Field[] fields = clazz.getDeclaredFields();
            for(Field temp: fields) {
                System.out.println("属性: " + temp);
            }

            // 获取方法信息
            Method[] method = clazz.getDeclaredMethods();
            Method m1 = clazz.getDeclaredMethod("getName", null);
            Method m2 = clazz.getDeclaredMethod("setName", String.class);
            for(Method m: method) {
                System.out.println("方法：" + m);
            }

            // 获得构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor c1 = clazz.getDeclaredConstructor(null);
            Constructor c2 = clazz.getDeclaredConstructor(int.class, int.class, String.class);

            for(Constructor constructor : constructors) {
                System.out.println("构造器：" + constructor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
