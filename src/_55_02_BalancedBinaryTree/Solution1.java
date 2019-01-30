package _55_02_BalancedBinaryTree;

import pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/30
 */
public class Solution1 {

    public boolean IsBalanced_Solution(TreeNode root) {

        // 空树是平衡的二叉树
        if (root == null) {
            return true;
        }

        return balancedHelper(root) != -1;
    }

    private int balancedHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = balancedHelper(root.left);
        if (left == -1) {
            return -1;
        }

        int right = balancedHelper(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
