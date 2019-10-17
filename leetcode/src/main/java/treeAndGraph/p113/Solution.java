package treeAndGraph.p113;

import treeAndGraph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode: 113. 路径总和 II
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        treeOrder(root, sum, 0, new Stack<Integer>(), result);
        return result;
    }

    private void treeOrder(TreeNode root, int sum, int pathValue, Stack<Integer> tmp, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        tmp.add(root.val);
        pathValue += root.val;
        if (root.left == null && root.right == null) {
            if (sum == pathValue) {
                result.add(new ArrayList<>(tmp));
            }
        }

        treeOrder(root.left, sum, pathValue, tmp, result);
        treeOrder(root.right, sum, pathValue, tmp, result);

        tmp.pop();
        pathValue -= root.val;
    }
}
