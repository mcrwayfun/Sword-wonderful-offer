package _07_01_ConstructBinaryTree;

import pojo.TreeNode;
import utils.TreeNodeUtil;

import java.util.Arrays;

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
        int len = rootIndex - inOrderStartIndex;
        if (len > 0) {
            // 构建左子树
            // 前序数组的左子树取值范围为[preOrderStartIndex + 1,preOrderStartIndex + len]
            // 中序数组的左子树取值范围为[inOrderStartIndex，rootIndex - 1]
            root.left = constructBinaryTree(preOrder, preOrderStartIndex + 1, preOrderStartIndex + len,
                    inOrder, inOrderStartIndex, rootIndex - 1);
        }

        if (rootIndex < inOrderEndIndex) {
            // 构建右子树
            // 前序数组的右子树取值范围为[preOrderStartIndex + len + 1,preOrderEndIndex]
            // 中序数组的右子树取值范围为[rootIndex + 1,inOrderEndIndex]
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
        // 前序遍历
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        // 中序遍历
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = new Solution().reConstructBinaryTree(preOrder, inOrder);
        System.out.println("前序遍历的二叉树" + Arrays.toString(preOrder) + "构造的二叉树前序遍历为" + TreeNodeUtil.preOrder(treeNode));

        // 只有一个节点的二叉树
        /**
         *     3
         */
        preOrder = new int[]{3};
        inOrder = new int[]{3};
        treeNode = new Solution().reConstructBinaryTree(preOrder, inOrder);
        System.out.println("前序遍历的二叉树" + Arrays.toString(preOrder) + "构造的二叉树前序遍历为" + TreeNodeUtil.preOrder(treeNode));

        // 只有左子树的二叉树
        /**
         *     3
         *    /
         *   9
         *  / \
         * 4   5
         *
         */
        preOrder = new int[]{3, 9, 4, 5};
        inOrder = new int[]{4, 9, 5, 3};
        treeNode = new Solution().reConstructBinaryTree(preOrder, inOrder);
        System.out.println("前序遍历的二叉树" + Arrays.toString(preOrder) + "构造的二叉树前序遍历为" + TreeNodeUtil.preOrder(treeNode));

        // 只有右子树的二叉树
        /**
         *     3
         *      \
         *      20
         *     /  \
         *    15   7
         */
        preOrder = new int[]{3, 20, 15, 7};
        inOrder = new int[]{3, 15, 20, 7};
        treeNode = new Solution().reConstructBinaryTree(preOrder, inOrder);
        System.out.println("前序遍历的二叉树" + Arrays.toString(preOrder) + "构造的二叉树前序遍历为" + TreeNodeUtil.preOrder(treeNode));
    }

}
