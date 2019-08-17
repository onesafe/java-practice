package designpatten.creator.prototype;

/**
 * 如果需要短时间创建大量对象，并且new的过程比较耗时，则考虑使用原型模式
 *
 * new的方式创建耗时：11829
 * clone的方式创建耗时：13
 */
public class CloneTimeTest {

    public static void main(String[] args) throws Exception {
        testNew(1000);
        testClone(1000);
    }

    private static void testNew(int size) {
        long start = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            Laptop t = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("new的方式创建耗时：" + (end-start));
    }

    private static void testClone(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        Laptop t = new Laptop();
        for (int i=0; i<size; i++) {
            Laptop temp = (Laptop) t.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("clone的方式创建耗时：" + (end-start));
    }

}

class Laptop implements Cloneable {
    public Laptop() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}