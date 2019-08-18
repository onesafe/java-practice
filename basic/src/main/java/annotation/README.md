## 内置注解

* @Override

定义在java.lang.Override中，此注解只适用于修辞方法，表示一个方法声明打算重写超类的另一个方法声明

* @Deprecated

定义在java.lang.Deprecated中，此注解可用于修辞方法，属性，类。
表示不鼓励程序员使用这样的元素，通常是因为它很危险或存在更好的选择

* @SuppressWarnings

定义在java.lang.SuppressWarnings中，用来抑制编译时的警告信息

## 元注解

* @Target

用于描述注解的使用范围

* @Retention

表示需要在什么级别保持该注解信息，用于描述注解的生命周期


SOURCE: 在源文件有效

CLASS: 在class文件中有效

RUNTIME: 在运行时有效，可以被反射机制读取

