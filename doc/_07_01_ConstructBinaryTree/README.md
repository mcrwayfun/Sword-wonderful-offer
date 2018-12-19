## 从尾到头打印链表

### 题目描述

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列 `{1,2,4,7,3,5,6,8}` 和中序遍历序列 `{4,7,2,1,5,3,8,6}`，则重建二叉树并返回。

### 思路1

首先需要了解以下特性：

1. 在二叉树的前序遍历中，第一个值为根节点的值。上述例子前序遍历的1为根节点。
2. 在二叉树的中序遍历中，根节点的值一般在中间，左子树的值位于其左侧，右子树的值在其右侧。上述例子中序遍历1为根节点，其左侧｛4，7，2｝为左子树节点，｛5,3,8,6｝为右子树节点。
3. 在前序遍历中找到根节点，以此去遍历中序遍历，找到根节点位于中序遍历中的位置。此时，可以知道左子树节点个数（3个）和右子树节点个数（4个），同时可以知道前序遍历中｛2，4，7｝为左子树节点，｛3，5，6，8｝为右子树节点。

思路如下：

1. 根据`preOrder[preOrderStartIndex]`构造二叉树根节点
2. 若两个数组遍历完成，则返回root
3. 遍历中序数组，找到中序数组中的根节点下标rootIndex
4. 计算前序数组中左子树节点个数` len = rootIndex - preOrderStartIndex`
5. 如果`len > 0 ` 说明有左子树，则递归调用constructBinaryTree构建左子树
6. 如果`rootIndex < inOrderEndIndex ` 说明有右子树，则递归调用constructBinaryTree构建右子树

### 方法1

```java
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
}
```

- time complexity：O(n)
- space complexity：O(n)