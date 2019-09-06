package stack.p155;

import java.util.Stack;

/**
 * LeetCode 155. 最小栈
 *
 */
class MinStack {

    private Stack<Integer> data_stack;
    private Stack<Integer> min_stack;

    /** initialize your data structure here. */
    public MinStack() {
        data_stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        data_stack.push(x);

        // 如果最小值为空，直接将数据压入栈
        if (min_stack.empty()) {
            min_stack.push(x);
        } else {
            if (x > min_stack.peek()) {
                x = min_stack.peek();
            }
            min_stack.push(x);
        }
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(3);
        obj.pop();
        int p1 = obj.top();
        int p2 = obj.getMin();
        System.out.println(p1);
        System.out.println(p2);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */