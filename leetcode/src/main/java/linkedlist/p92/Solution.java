package linkedlist.p92;

import linkedlist.ListNode;

/**
 * LeetCode 92. 反转链表 II
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int changeLen = n - m + 1;
        ListNode preHead = null;
        ListNode result = head;

        while(head != null && m > 1) {
            preHead = head;
            head = head.next;
            m--;
        }

        ListNode modifyLastTail = head;
        ListNode newHead = null;

        // 中间段逆置，使用新的newHead指针，就地逆置
        while(head != null && changeLen > 0) {
            ListNode ptr = head.next;
            head.next = newHead;
            newHead = head;
            head = ptr;
            changeLen--;
        }

        modifyLastTail.next = head;

        if(preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }

        return result;
    }
}
