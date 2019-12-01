package linkedlist.p141;

import linkedlist.ListNode;

/**
 * LeetCode 141 环形链表
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast == null) {
                return false;
            }

            fast = fast.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
