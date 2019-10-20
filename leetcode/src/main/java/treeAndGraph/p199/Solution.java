package treeAndGraph.p199;

import treeAndGraph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode: 199. 二叉树的右视图
 *
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i == (size-1)) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}
