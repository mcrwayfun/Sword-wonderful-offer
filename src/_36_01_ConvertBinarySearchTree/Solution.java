package _36_01_ConvertBinarySearchTree;

import pojo.TreeNode;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/09
 * @description
 */
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        // 结果
        TreeNode res = null;
        // 前一个节点
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 找到树中最小的节点（最左的子树）
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 如果上一个节点不存在，表明是链表的开头节点
                if (pre == null) {
                    pre = cur;
                    res = pre;
                } else {
                    // 上一个节点的right指向后一个节点
                    pre.right = cur;
                    // 后一个节点的left指向上一个节点
                    cur.left = pre;
                    // 保留上一个节点
                    pre = cur;
                }
                cur = cur.right;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);

        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);

        node6.left = node4;
        node6.right = node8;

        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);
        TreeNode node14 = new TreeNode(14);

        node14.left = node12;
        node14.right = node16;

        node10.left = node6;
        node10.right = node14;

        new Solution().Convert(node10);
    }
}
