package TwoSearchTree.p538;

import treeAndGraph.TreeNode;

/**
 * LeetCode: 538. 把二叉搜索树转换为累加树
 */
public class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        travelTree(root);
        return root;
    }

    private void travelTree(TreeNode node) {
        if (node == null) {
            return;
        }

        travelTree(node.right);
        sum += node.val;
        node.val = sum;
        travelTree(node.left);
    }
}
