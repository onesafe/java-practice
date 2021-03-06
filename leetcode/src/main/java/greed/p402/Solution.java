package greed.p402;

import java.util.Stack;

/**
 * LeetCode 402. 移掉K位数字
 */
public class Solution {

    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 核心逻辑
        for (int i=0; i<num.length(); i++) {
            int n = num.charAt(i) - '0';

            while (stack.size() != 0 && k > 0 && stack.peek() > n) {
                stack.pop();
                k--;
            }

            if (n != 0 || stack.size() != 0) {
                stack.push(n);
            }
        }

        // 如果栈不空，则仍然可以删除数字
        while (stack.size() != 0 && k > 0) {
            k--;
            stack.pop();
        }


        while(stack.size() != 0) {
            sb.append(stack.peek());
            stack.pop();
        }


        /*
               "10"
               2
        */
        if ("".equals(sb.toString())) {
            return "0";
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res = removeKdigits("1432219", 3);
        System.out.println(res);
    }
}
