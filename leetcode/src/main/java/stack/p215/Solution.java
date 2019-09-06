package stack.p215;

import java.util.PriorityQueue;

/**
 * LeetCode 215. 数组中的第K个最大元素
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.add(n);
            } else {
                if (minHeap.peek() < n) {
                    minHeap.poll();
                    minHeap.add(n);
                }
            }
        }
        return minHeap.peek();
    }
}
