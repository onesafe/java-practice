package linkedlist.p142;

import linkedlist.ListNode;

/**
 * LeetCode 142. 环形链表 II
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;

            if(fast == null) {
                return null;
            }

            fast = fast.next;
            if(fast == slow) {
                meet = fast;
                break;
            }
        }

        while(head != null && meet != null) {
            if(head == meet) {
                return head;
            }
            head = head.next;
            meet = meet.next;
        }

        return null;
    }
}
