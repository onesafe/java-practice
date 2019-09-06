package stack.poj1363;

import java.util.LinkedList;
import java.util.Stack;

/**
 * POJ 1363 合法的出栈序列
 */
public class ValidOrder {

    private Boolean checkIsValidOrder(LinkedList<Integer> order) {
        Stack<Integer> s = new Stack<>();
        int n = order.size();

        for (int i=1; i<=n; i++) {
            s.push(i);

            // 只要S不空，且队列头部与栈顶相同，既弹出元素
            while(!s.empty() && s.peek().equals(order.peek())) {
                s.pop();
                order.pop();
            }
        }

        return s.empty();
    }
}
