package _55_02_BalancedBinaryTree;

import pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/30
 */
public class Solution {

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {

        // 空树也是平衡二叉树
        if (root == null) {
            return true;
        }

        balancedHelper(root);

        return isBalanced;
    }

    private int balancedHelper(TreeNode root) {

        // 当前结点为空或者之前遍历的已经存在非平衡情况，则直接返回0
        if (root == null || !isBalanced) {
            return 0;
        }

        int left = balancedHelper(root.left);
        int right = balancedHelper(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }
}
