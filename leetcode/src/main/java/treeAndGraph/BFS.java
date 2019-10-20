package treeAndGraph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树的宽度优先搜索
 */
public class BFS {

    private static void bfs(TreeNode root) {
        Queue<TreeNode> Q = new LinkedBlockingQueue<>();

        Q.add(root);

        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();

            System.out.println(node.val);

            if (node.left != null) {
                Q.add(node.left);
            }

            if (node.right != null) {
                Q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        bfs(a);
    }
}
