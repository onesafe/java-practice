package linkedlist.p160;

import linkedlist.ListNode;

/**
 * LeetCode 160. 相交链表
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        int gap = 0;

        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != null) {
            lenA++;
            pA = pA.next;
        }

        while(pB != null) {
            lenB++;
            pB = pB.next;
        }

        pA = headA;
        pB = headB;

        if (lenA < lenB) {
            gap = lenB - lenA;
            while(gap > 0) {
                pB = pB.next;
                gap--;
            }
        } else {
            gap = lenA - lenB;
            while(gap > 0) {
                pA = pA.next;
                gap--;
            }
        }

        while(pA != null && pB != null) {
            if(pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null;
    }
}
