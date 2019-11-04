package TwoSearchTree.p450;

import treeAndGraph.TreeNode;

/**
 * LeetCode: 450. 删除二叉搜索树中的节点
 */
public class Solution {

    private TreeNode parent;

    public TreeNode deleteNode(TreeNode root, int key) {
        // 找到待删除节点
        TreeNode node = bstSearch(root, key);
        if (node == null) {
            return root;
        }

        // 删除的节点有左右子树的时候
        if (node.left != null && node.right != null) {
            TreeNode successor = findSuccessor(node);
            node.val = successor.val;
            deleteNode(successor);
            return root;
        }

        // 当待删除节点不是根节点的时候
        if (parent != null) {
            deleteNode(node);
            return root;
        }

        // 当待删除节点是根节点的时候
        if (node.left != null) {
            root = node.left;
        } else if (node.right != null) {
            root = node.right;
        } else {
            root = null;
        }
        return root;
    }

    // 如果删除的节点有两个子树，找到待删除节点的后继节点
    private TreeNode findSuccessor(TreeNode node) {
        parent = node;

        TreeNode ptr = node.right;
        while (ptr.left != null) {
            parent = ptr;
            ptr = ptr.left;
        }
        return ptr;
    }

    // 删除的节点只有一个子树，或者是叶子节点
    private void deleteNode(TreeNode node) {
        if (node.val < parent.val) {
            if (node.left == null && node.right != null) {
                parent.left = node.right;
            } else if (node.left != null && node.right == null) {
                parent.left = node.left;
            } else {
                parent.left = null;
            }
        } else {
            if (node.left == null && node.right != null) {
                parent.right = node.right;
            } else if (node.left != null && node.right == null) {
                parent.right = node.left;
            } else {
                parent.right = null;
            }
        }
    }

    private TreeNode bstSearch(TreeNode node, int value) {
        while (null != node) {
            if (node.val == value) {
                break;
            }

            parent = node;

            if (node.val < value) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

}
