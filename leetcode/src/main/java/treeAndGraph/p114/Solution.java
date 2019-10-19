package treeAndGraph.p114;

import treeAndGraph.TreeNode;

/**
 * LeetCode: 114. 二叉树展开为链表
 */
public class Solution {

    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }

        pre = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
