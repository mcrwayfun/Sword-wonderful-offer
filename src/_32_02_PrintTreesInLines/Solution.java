package _32_02_PrintTreesInLines;

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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> reList = new ArrayList<>();

        if (pRoot == null) {
            return reList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {

            int level = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
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

            reList.add(list);
        }

        return reList;
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

        ArrayList<ArrayList<Integer>> list = new Solution().Print(root);
        for (ArrayList<Integer> tempList : list) {
            for (int x : tempList) {
                System.out.print(x);
            }
            System.out.println();
        }

    }
}
