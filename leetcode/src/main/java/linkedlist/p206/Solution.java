package linkedlist.p206;

import linkedlist.ListNode;

/**
 * LeetCode 206. 反转链表
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode new_head = new ListNode(0);
        ListNode ptr = head;

        while(head != null) {
            ptr = head.next;
            head.next = new_head.next;
            new_head.next = head;
            head = ptr;
        }

        return new_head.next;
    }
}
