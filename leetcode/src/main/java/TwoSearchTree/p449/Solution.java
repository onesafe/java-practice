package TwoSearchTree.p449;

import treeAndGraph.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 449. 序列化和反序列化二叉搜索树
 */
public class Solution {

    private String data = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        bstPreOrder(root);
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if ("".equals(data)) {
            return null;
        }

        String[] datas = data.split("#");
        for (String d : datas) {
            treeNodes.add(new TreeNode(Integer.valueOf(d)));
        }

        TreeNode root = treeNodes.get(0);
        for(int i = 1;i < treeNodes.size(); i++){
            insertLoop(root, treeNodes.get(i));
        }
        return root;
    }

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

    private void bstPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        data = data + String.valueOf(node.val) + "#";
        bstPreOrder(node.left);
        bstPreOrder(node.right);
    }
}
