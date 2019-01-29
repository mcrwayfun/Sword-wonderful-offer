package _55_01_TreeDepth;

import pojo.TreeNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/29
 * @description
 */
public class Solution {

    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;
    }

}
