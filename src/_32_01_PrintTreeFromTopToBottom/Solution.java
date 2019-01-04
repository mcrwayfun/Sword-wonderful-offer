package _32_01_PrintTreeFromTopToBottom;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/4
 */
public class Solution {

    /**
     * 从上到下，从左到右遍历树
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 进行BFS
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                list.add(node.val);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);

        root.left = root2;
        root.right = root3;

        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        root3.left = new TreeNode(6);
        root3.right = new TreeNode(7);

        ArrayList<Integer> integers = new Solution().PrintFromTopToBottom(root);
        for (int x : integers) {
            System.out.println(x);
        }

    }
}
