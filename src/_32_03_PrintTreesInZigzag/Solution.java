package _32_03_PrintTreesInZigzag;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/06
 * @description
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> reList = new ArrayList<>();
        if (pRoot == null) {
            return reList;
        }

        // 使用两个栈来实现树的之字形打印
        // 奇数层，则先压入左子树，后右子树
        // 偶数层，则先压入右子树，后左子树

        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        // 层数（从1开始）
        int level = 1;
        while (!stack.empty()) {

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            boolean isOdd = level % 2 == 1;
            int size = stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            // 打印同一层的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                list.add(node.val);

                // 奇数
                if (isOdd) {
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                }
                // 偶数
                else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }
            }
            reList.add(list);
            level++;
            stack = stack1.empty() ? stack2 : stack1;
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
