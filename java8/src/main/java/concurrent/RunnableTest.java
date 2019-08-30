package concurrent;

import static java.lang.Thread.sleep;

/**
 * Created by onesafe on 30/08/2019 5:53 PM.
 */
public class RunnableTest {

    public static void main(String[] args) {

        Runnable task = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                sleep(3000);
                System.out.println("Hello " + threadName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        task.run();


        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }
}
