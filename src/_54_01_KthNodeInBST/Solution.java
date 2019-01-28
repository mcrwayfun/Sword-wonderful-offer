package _54_01_KthNodeInBST;

import pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/28
 */
public class Solution {

    private TreeNode retNode = null;
    private Integer count = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k == 0) {
            return null;
        }
        count = k;
        midOrder(pRoot);
        return retNode;
    }

    private void midOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        midOrder(root.left);
        if (count == 1 && retNode == null) {
            retNode = root;
            return;
        } else {
            count--;
        }
        midOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);

        node3.left = node2;
        node3.right = node4;

        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);

        node7.left = node6;
        node7.right = node8;

        TreeNode node5 = new TreeNode(5);
        node5.left = node3;
        node5.right = node7;

        TreeNode treeNode = new Solution().KthNode(node5, 3);
        System.out.println(treeNode.val);
    }
}
