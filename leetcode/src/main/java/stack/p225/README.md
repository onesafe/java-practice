## 用队列实现栈

在push元素时，利用临时队列调换元素次序

将新元素push进入临时队列temp

将原队列内容push进入临时队列temp

将临时队列temp 元素push进入数据队列

最终数据队列的效果就如果栈一样