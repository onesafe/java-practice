package TwoSearchTree;

import treeAndGraph.TreeNode;

/**
 * 二叉查找树（二叉排序树）
 */
public class BST {

    // 递归实现插入
    public void insertDg(TreeNode node, TreeNode insertNode) {
        if (insertNode.val < node.val) {
            if (null != node.left) {
                insertDg(node.left, insertNode);
            } else {
                node.left = insertNode;
            }
        } else {
            if (null != node.right) {
                insertDg(node.right, insertNode);
            } else {
                node.right = insertNode;
            }
        }
    }

    // 循环实现插入
    public void insertLoop(TreeNode node, TreeNode insertNode) {
        while (node != insertNode) {
            if (insertNode.val < node.val) {
                if (null == node.left) {
                    node.left = insertNode;
                }
                node = node.left;
            } else {
                if (null == node.right) {
                    node.right = insertNode;
                }
                node = node.right;
            }
        }
    }
}
