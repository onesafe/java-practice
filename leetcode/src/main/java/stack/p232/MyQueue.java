package stack.p232;

import java.util.Stack;

/**
 * LeetCode 232. 用栈实现队列
 *
 */
class MyQueue {

    private Stack<Integer> input_stack;
    private Stack<Integer> output_stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        input_stack = new Stack<>();
        output_stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input_stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        adjust();
        int x = output_stack.peek();
        output_stack.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        adjust();
        return output_stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input_stack.empty() && output_stack.empty();
    }

    private void adjust() {
        if (!output_stack.empty()) {
            return;
        }

        while(!input_stack.empty()) {
            output_stack.push(input_stack.peek());
            input_stack.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(3);
        m.push(4);
        m.push(5);
        int p2 = m.pop();
        int p3 = m.peek();
        boolean p4 = m.empty();
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */