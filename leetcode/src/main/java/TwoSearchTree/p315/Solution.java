package TwoSearchTree.p315;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 315. 计算右侧小于当前元素的个数
 */
public class Solution {

    public int countSmall = 0;

    class BSTNode {
        public int val;
        public int count;
        public BSTNode left;
        public BSTNode right;
        public BSTNode(int x) { val = x; }
    }

    public void BSTInsert(BSTNode node, BSTNode insertNode) {
        if (insertNode.val <= node.val) {
            node.count++;
            if (node.left != null) {
                BSTInsert(node.left, insertNode);
            } else {
                node.left = insertNode;
            }
        } else {
            countSmall += node.count + 1;
            if (node.right != null) {
                BSTInsert(node.right, insertNode);
            } else {
                node.right = insertNode;
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<BSTNode> nodes = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        // 从后向前的顺序创建二叉查找树节点
        for (int i=nums.length-1; i>=0; i--) {
            nodes.add(new BSTNode(nums[i]));
        }

        count.add(0);

        for (int i=1; i<nodes.size(); i++) {
            countSmall = 0;
            BSTInsert(nodes.get(0), nodes.get(i));
            count.add(countSmall);
        }

        // 调换count数组顺序得到最终结果
        for (int i=nodes.size()-1; i>=0; i--) {
            result.add(count.get(i));
        }
        return result;
    }
}
