## 二叉搜索树的第k个结点

### 题目描述

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4

### 思路1
因为BST的中序遍历得到的是一个升序的列表，所以在进行中序遍历行进行判断即可。

```java
public class Solution {
    
    private int count = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k == 0) {
            return null;
        }

        // 左递归
        TreeNode retNode = KthNode(pRoot.left, k);

        if (retNode != null) {
            return retNode;
        }

        // 符合条件则返回
        count++;
        if (count == k) {
            return pRoot;
        }

        // 右递归
        retNode = KthNode(pRoot.right, k);
        if (retNode != null) {
            return retNode;
        }

        return null;
    }
}
```
- time complexity:O(logn)
- space complexity:O(1)

