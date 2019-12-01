package linkedlist.p138;

import linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 138 复制带随机指针的链表
 */
public class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> visited = new HashMap<>();
        Node pPrev = null;
        Node pNode = head;

        // 循环一次，创建新的链表
        while(pNode != null) {
            Node pNew = new Node();
            visited.put(pNode, pNew);
            pNode = pNode.next;
        }

        pNode = head;

        // 循环一次，在新的链表上，将随机指针给填上
        while(pNode != null) {
            Node pNew = visited.get(pNode);
            pNew.val = pNode.val;
            pNew.random = visited.get(pNode.random);
            pNew.next = null;

            if(pPrev != null) {
                visited.get(pPrev).next = pNew;
            }

            pPrev = pNode;
            pNode = pNode.next;
        }
        return visited.get(head);
    }
}
