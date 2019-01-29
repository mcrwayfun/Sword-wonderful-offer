## 二叉树的深度

### 题目描述

输入一棵二叉树的根结点，求该树的深度。

从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

### 思路1


```java
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
```
- time complexity:O(n)
- space complexity:O(1)

