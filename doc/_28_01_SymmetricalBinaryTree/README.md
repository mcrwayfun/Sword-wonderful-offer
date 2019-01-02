## 对称的二叉树

### 题目描述

请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

### 思路

比较前序遍历（根左右）和自定义前序遍历（根右左）序列是否相等即可


### 方法

```java
public class Solution {

    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        // 两个都为null则是对称的
        if (root1 == null && root2 == null) {
            return true;
        }

        // 一个为null则为false
        if (root1 == null || root2 == null) {
            return false;
        }

        // 值不等则返回false
        if (root1.val != root2.val) {
            return false;
        }

        // 递归判断
        // root1使用前序（根左右）
        // root2使用自定义前序（根右左）
        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
