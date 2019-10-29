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

    // 递归实现查找
    public boolean findDg(TreeNode node, Integer val) {
        if (node.val == val) {
            return true;
        }

        if (val < node.val) {
            if (null != node.left) {
                return findDg(node.left, val);
            } else {
                return false;
            }
        } else {
            if (null != node.right) {
                return findDg(node.right, val);
            } else {
                return false;
            }
        }
    }

    // 循环实现查找
    public boolean findLoop(TreeNode node, Integer val) {
        while (node != null) {
            if (node.val == val) {
                return true;
            }

            if (node.val < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return false;
    }
}
