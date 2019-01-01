## 树的子结构

### 题目描述

输入两棵二叉树`A`，`B`，判断`B`是不是`A`的子结构。（ps：我们约定空树不是任意一个树的子结构）

### 思路

递归方式遍历：

- 在树A中找到和树B的根结点值一样的结点R
- 判断树A以R为根结点的子树是否包含与树B一样的结构


### 方法

```java
public class Solution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {

        if (root2 == null) {
            return true;
        }

        // 在root2，root1遍历完成后，仍未找到符合的结构，返回false
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
```

- time complexity:O(n*m)，root1的每一个节点均要遍历m次（m为root2的节点个数）
- space complexity:O(1)
