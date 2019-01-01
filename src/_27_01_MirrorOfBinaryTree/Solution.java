package _27_01_MirrorOfBinaryTree;

import pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/01
 * @description
 */
public class Solution {

    public void Mirror(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        // 交换根节点左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归交换左右子树的子节点
        Mirror(root.left);
        Mirror(root.right);
    }

}
