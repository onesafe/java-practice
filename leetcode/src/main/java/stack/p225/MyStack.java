package stack.p225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 */
public class MyStack {
    private Queue<Object> data;
    private Queue<Object> temp;

    public MyStack() {
        data = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int x) {
        temp.add(x);

        while(!data.isEmpty()) {
            temp.add(data.peek());
            data.remove();
        }

        while(!temp.isEmpty()) {
            data.add(temp.peek());
            temp.remove();
        }
    }

    public int pop() {
        int top = (Integer) data.peek();
        data.remove();
        return top;
    }

    public int top() {
        return (Integer) data.peek();
    }

    public boolean empty() {
        return data.isEmpty();
    }


    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(4);
        int p1 = obj.top();
        int p2 = obj.pop();
        boolean p4 = obj.empty();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p4);
    }
}
