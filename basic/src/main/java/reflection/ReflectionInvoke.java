package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ReflectionInvoke {

    public static void main(String[] args) {
        String path = "reflection.User";

        try {
            Class<User> clazz = (Class<User>) Class.forName(path);

            // 通过反射API调用构造方法，构造对象
            User u = clazz.newInstance();
            System.out.println(u);

            Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            User u2 = c.newInstance(1001, 18, "张三");
            System.out.println(u2.getName());

            // 通过反射API调用普通方法
            User u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.invoke(u3, "李四");
            System.out.println(u3.getName());

            // 通过反射API操作属性
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true);  // 这个属性不需要做安全检查了，可以直接访问
            f.set(u4, "王五");
            System.out.println(u4.getName());
            System.out.println(f.get(u4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
