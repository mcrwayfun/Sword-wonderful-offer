## 平衡二叉树

### 题目描述

输入一棵二叉树的根结点，判断该树是不是平衡二叉树。

如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

### 思路1

通过获取树的深度的方法来判断即可。注意，如果使用前序遍历，那么会存在同一结点遍历多次的情况，所以使用后序遍历来实现。


```java
public class Solution {
    
    public boolean IsBalanced_Solution(TreeNode root) {

        // 空树是平衡的二叉树
        if (root == null) {
            return true;
        }

        return balancedHelper(root) != -1;
    }

    private int balancedHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = balancedHelper(root.left);
        if (left == -1) {
            return -1;
        }

        int right = balancedHelper(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
```
- time complexity:O(n)
- space complexity:O(1)

