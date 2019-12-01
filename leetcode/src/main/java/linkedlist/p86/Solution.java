package linkedlist.p86;

import linkedlist.ListNode;

/**
 * LeetCode 86 分隔链表
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);

        ListNode lessPtr = lessHead;
        ListNode morePtr = moreHead;

        while(head != null) {
            if(head.val < x) {
                lessPtr.next = head;
                lessPtr = head;
            } else {
                morePtr.next = head;
                morePtr = head;
            }
            head = head.next;
        }

        lessPtr.next = moreHead.next;
        morePtr.next = null;

        return lessHead.next;
    }
}
