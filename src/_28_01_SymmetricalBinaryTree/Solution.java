package _28_01_SymmetricalBinaryTree;

import pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/02
 * @description
 */
public class Solution {

    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        // 两个都为null则是对称的
        if (root1 == null && root2 == null) {
            return true;
        }

        // 一个为null则为false
        if (root1 == null || root2 == null) {
            return false;
        }

        // 值不等则返回false
        if (root1.val != root2.val) {
            return false;
        }

        // 递归判断
        // root1使用前序（根左右）
        // root2使用自定义前序（根右左）
        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }
}
