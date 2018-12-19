package _08_01_NextNodeInBinaryTrees;

import pojo.TreeLinkNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/19
 */
public class Solution {

    /**
     * 获取中序遍历的下一个节点
     *
     * @param pNode 某个节点
     * @return pNode的下一个节点
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        // pNode的右子树不为空，则下一个节点必定为其右子树最左节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            if (right.left != null) {
                right = right.left;
            }
            return right;
        }
        // pNode右子树为空且不存在父节点，则pNode为根节点
        // 不存在中序遍历下一个节点，直接返回null
        else if (pNode.next == null) {
            return null;
        }
        // pNode不存在右子树且存在父节点
        else {

            // pNode是其父节点的左孩子
            if (pNode.next.left == pNode) {
                return pNode.next;
            }

            // pNode是其父节点的右孩子
            // 沿着父节点向上找到某个节点，这个节点是其父节点的左孩子
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {
                    return pNode.next;
                }

                pNode = pNode.next;
            }

            return null;
        }
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
        // 中序遍历[9,3,15,20,7]
        TreeLinkNode node15 = new TreeLinkNode(15);
        TreeLinkNode node20 = new TreeLinkNode(20);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node15.next = node20;
        node20.left = node15;
        node20.right = node7;
        node20.next = node7;


        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node9 = new TreeLinkNode(9);
        node9.next = node3;

        node3.left = node9;
        node3.right = node20;
        node3.next = node20;

        // pNode存在右子树
        TreeLinkNode pNode = node3;
        TreeLinkNode next = new Solution().getNext(pNode);
        System.out.println("中序遍历的二叉树为[9,3,15,20,7],节点[" + pNode + "]的下一个节点为[" + next + "]");

        // pNode不存在右子树但有父节点，且是父节点的左孩子
        pNode = node15;
        next = new Solution().getNext(pNode);
        System.out.println("中序遍历的二叉树为[9,3,15,20,7],节点[" + pNode + "]的下一个节点为[" + next + "]");

        // pNode不存在右子树但有父节点，且是父节点的右孩子
        pNode = node7;
        next = new Solution().getNext(pNode);
        System.out.println("中序遍历的二叉树为[9,3,15,20,7],节点[" + pNode + "]的下一个节点为[" + next + "]");
    }
}
