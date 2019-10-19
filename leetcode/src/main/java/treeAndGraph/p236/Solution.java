package treeAndGraph.p236;

import treeAndGraph.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode: 236. 二叉树的最近公共祖先
 */
public class Solution {

    public static List<TreeNode> pResult;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, new Stack<>());
        List<TreeNode> pNodePath = new ArrayList<>(pResult);

        dfs(root, q, new Stack<>());
        List<TreeNode> qNodePath = new ArrayList<>(pResult);

        int len = pNodePath.size() > qNodePath.size() ? qNodePath.size() : pNodePath.size();
        TreeNode tmp = new TreeNode(0);
        for (int i=0; i<len; i++) {
            if (pNodePath.get(i) == qNodePath.get(i)) {
                tmp = pNodePath.get(i);
            }
        }
        return tmp;
    }

    public static void dfs(TreeNode root, TreeNode search, Stack<TreeNode> path) {
        if (root == null) {
            return;
        }

        path.add(root);

        if (root == search) {
            pResult = new ArrayList<>(path);
            return;
        }

        dfs(root.left, search, path);
        dfs(root.right, search, path);

        path.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(6);
        TreeNode p4 = new TreeNode(2);
        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(8);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(4);

        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        p4.left = p7;
        p4.right = p8;

        TreeNode r = lowestCommonAncestor(root, p1, p2);
        System.out.println(r.val);
    }

}