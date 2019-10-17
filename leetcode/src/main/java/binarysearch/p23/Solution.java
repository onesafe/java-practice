package binarysearch.p23;

/**
 * LeetCode: 23. 合并K个排序链表
 * 分治，归并
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length-1);
    }

    private ListNode solve(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) >> 1;
        ListNode lNode = solve(lists, left, mid);
        ListNode rNode = solve(lists, mid+1, right);

        return merge(lNode, rNode);
    }

    private ListNode merge(ListNode lNode, ListNode rNode) {
        if (lNode == null) {
            return rNode;
        }
        if (rNode == null) {
            return lNode;
        }

        if (lNode.val <= rNode.val) {
            lNode.next = merge(lNode.next, rNode);
            return lNode;
        } else {
            rNode.next = merge(lNode, rNode.next);
            return rNode;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

