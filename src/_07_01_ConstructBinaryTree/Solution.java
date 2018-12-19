package _07_01_ConstructBinaryTree;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/19
 */
public class Solution {

    public TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null
                || preOrder.length != inOrder.length) {
            return null;
        }

        int length = preOrder.length - 1;

        return constructBinaryTree(preOrder, 0, length, inOrder, 0, length);
    }

    /**
     * 构造二叉树
     *
     * @param preOrder           前序遍历输出的数组
     * @param preOrderStartIndex 前序遍历起始下标
     * @param preOrderEndIndex   前序遍历终止下标
     * @param inOrder            中序遍历输出数组
     * @param inOrderStartIndex  中序遍历起始下标
     * @param inOrderEndIndex    中序遍历终止下标
     * @return 二叉树
     */
    private TreeNode constructBinaryTree(int[] preOrder, int preOrderStartIndex, int preOrderEndIndex,
                                         int[] inOrder, int inOrderStartIndex, int inOrderEndIndex) {

        // 根节点
        int rootValue = preOrder[preOrderStartIndex];
        TreeNode root = new TreeNode(rootValue);

        // 两个数组遍历均完成
        if (preOrderStartIndex == preOrderEndIndex
                && inOrderStartIndex == inOrderEndIndex) {
            return root;
        }

        // 遍历中序数组，找到中序数组中的根节点下标
        int rootIndex = preOrderStartIndex;
        while (preOrder[preOrderStartIndex] != inOrder[rootIndex]) {
            rootIndex++;
        }

        // 计算前序数组中左子树节点个数
        int len = rootIndex - preOrderStartIndex;
        if (len > 0) {
            // 构建左子树
            root.left = constructBinaryTree(preOrder, preOrderStartIndex + 1, preOrderStartIndex + len,
                    inOrder, inOrderStartIndex, rootIndex - 1);
        }

        if (rootIndex < inOrderEndIndex) {
            // 构建右子树
            root.right = constructBinaryTree(preOrder, preOrderStartIndex + len + 1, preOrderEndIndex,
                    inOrder, rootIndex + 1, inOrderEndIndex);
        }

        return root;
    }

    public static void main(String[] args) {
        // 普通二叉树
        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);

        TreeNode root20 = new TreeNode(20);
        root20.left = root15;
        root20.right = root7;

        TreeNode root9 = new TreeNode(9);

        TreeNode root3 = new TreeNode(3);
        root3.left = root9;
        root3.right = root20;

        // 前序遍历
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        // 中序遍历
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = new Solution().reConstructBinaryTree(preOrder, inOrder);
        System.out.println(preOrder(treeNode));
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> reList = new ArrayList<>();
        if (root == null) {
            return reList;
        }
        preOrder(root, reList);

        return reList;
    }

    private static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
