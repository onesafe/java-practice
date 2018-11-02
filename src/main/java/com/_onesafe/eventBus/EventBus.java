package com._onesafe.eventBus;


import java.util.concurrent.Executor;

/**
 * Created by onesafe on 02/11/2018.
 */
public class EventBus implements Bus {

    // 用于维护Subscriber的注册表
    private final Registry registry = new Registry();

    // Event Bus的名字
    private String busName;

    // 默认的Event Bus的名字
    private final static String DEFAULT_BUS_NAME = "default";

    // 默认的topic的名字
    private final static String DEFAULT_TOPIC = "default-topic";

    // 用于分发广播消息到各个Subscriber的类
    private final Dispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_BUS_NAME, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName) {
        this(busName, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    EventBus(String busName, EventExceptionHandler exceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = Dispatcher.newDispatcher(exceptionHandler, executor);
    }

    public EventBus(EventExceptionHandler exceptionHandler) {
        this(DEFAULT_BUS_NAME, exceptionHandler, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    // 将注册的Subscriber的动作直接委托给Registry
    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    // 解除注册同样委托给Registry
    @Override
    public void unregister(Object subscriber) {
        this.registry.unbind(subscriber);
    }

    // 提交Event到默认的topic
    @Override
    public void post(Object event) {
        this.post(event, DEFAULT_TOPIC);
    }

    // 提交Event到指定的topic，具体的动作是由Dispatcher来完成的
    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    // 关闭销毁Bus
    @Override
    public void close() {
        this.dispatcher.close();
    }

    // 返回Bus的名称
    @Override
    public String getBusName() {
        return this.busName;
    }


}
