package thread;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 *
 * Created by onesafe on 29/08/2019 11:37 AM.
 */
public class MyThreadPool {

    private int corePoolSize = 10;

    private int maximumPoolSize = 30;

    private long keepAliveTime = 1000;

    private TimeUnit unit = MILLISECONDS;

    private int blockingQueue = 20;

    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(blockingQueue);

    private ThreadFactory threadFactory = Executors.defaultThreadFactory();

    /**
     * 系统默认的拒绝策略有以下几种：

     AbortPolicy：为线程池默认的拒绝策略，该策略直接抛异常处理。
     DiscardPolicy：直接抛弃不处理。
     DiscardOldestPolicy：丢弃队列中最老的任务。
     CallerRunsPolicy：将任务分配给当前执行execute方法线程来处理。

     我们还可以自定义拒绝策略，只需要实现RejectedExecutionHandler接口即可，友好的拒绝策略实现有如下：

     将数据保存到数据，待系统空闲时再进行处理将数据用日志进行记录，后由人工处理
     */
    private RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            // 线程池核心线程数量，核心线程不会被回收，即使没有任务执行，也会保持空闲状态。
            // 如果线程池中的线程少于此数目，则在执行任务时创建。
            corePoolSize,

            // 池允许最大的线程数，当线程数量达到corePoolSize，且workQueue队列塞满任务了之后，继续创建线程。
            maximumPoolSize,

            // 超过corePoolSize之后的“临时线程”的存活时间。
            keepAliveTime,

            // keepAliveTime的单位。
            unit,

            // 当前线程数超过corePoolSize时，新的任务会处在等待状态，并存在workQueue中，
            // BlockingQueue是一个先进先出的阻塞式队列实现，底层实现会涉及Java并发的AQS机制
            workQueue,

            // 创建线程的工厂类，通常我们会自顶一个threadFactory设置线程的名称，
            // 这样我们就可以知道线程是由哪个工厂类创建的，可以快速定位。
            threadFactory,

            // 线程池执行拒绝策略，当线数量达到maximumPoolSize大小，
            // 并且workQueue也已经塞满了任务的情况下，线程池会调用handler拒绝策略来处理请求。
            handler
    );

}


/**
从JDK源码可看出，Executors工具类无非是把一些特定参数进行了封装，并提供一些方法供我们调用而已，
 我们并不能灵活地填写参数，策略过于简单，不够友好。

CachedThreadPool和ScheduledThreadPool最大线程数为Integer.MAX_VALUE，如果线程无限地创建，会造成OOM异常。

LinkedBlockingQueue基于链表的FIFO队列，是无界的，默认大小是Integer.MAX_VALUE，
 因此FixedThreadPool和SingleThreadPool的阻塞队列长度为Integer.MAX_VALUE，
 如果此时队列被无限地堆积任务，会造成OOM异常。
*/