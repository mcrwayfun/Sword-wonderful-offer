## 二叉树的镜像

### 题目描述

操作给定的二叉树，将其变换为源二叉树的镜像。

```java
源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11

镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
```

### 思路

将根结点的左右孩子互换，之后递归左右孩子。


### 方法

```java
public class Solution {

    public void Mirror(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        // 交换根节点左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归交换左右子树的子节点
        Mirror(root.left);
        Mirror(root.right);
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
