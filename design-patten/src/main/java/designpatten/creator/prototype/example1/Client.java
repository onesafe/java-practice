package designpatten.creator.prototype.example1;

import java.util.Date;

public class Client {

    public static void main(String[] args) throws Exception {
        Date d = new Date(12343121223L);
        Sheep s1 = new Sheep("少利", d);
        Sheep s2 = (Sheep) s1.clone();

        System.out.println(s1);

        d.setTime(13738393932728L);
        System.out.println(s1);

        System.out.println(s2);
    }
}
