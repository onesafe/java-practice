单例的实现方式有很多，分为两大类
* 饿汉模式
* 懒汉模式

如果我们在程序启动后，一定会加载到类，那么用饿汉模式实现的单例简单又实用；
如果我们是写一些工具类，则优先实用懒汉模式，因为很多项目可能会引用jar包，但未必
会使用到这个工具类，懒汉模式实现的单例可以避免提前被加载到内存中，占用系统资源

懒汉模式推荐使用 枚举类实现方式
枚举类实现的单例是最安全的，反射和序列化都是单例。

<<Effective Java>>作者也是强烈推荐枚举方式实现单例