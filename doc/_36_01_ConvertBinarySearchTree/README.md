## 二叉搜索树与双向链表

### 题目描述

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

### 思路

中序遍历输出的本身就是升序的列表。使用一个栈来存储中序遍历数组，比如现在有如下的树：

![](https://ws1.sinaimg.cn/large/0062R7s4gy1fz1bub3bivj306i05kglr.jpg)

1. 遍历树，向栈中压入根节点以及左子树。如上例子，现在压入栈中元素为：head[10,6,4]tail
2. 当cur为空，即已经遍历到最左边时，执行else部分。推出栈顶元素4作为链表头节点，并记录pre（前一个节点），因为4的right为null，所以继续执行else。

### 方法

```java
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        // 结果
        TreeNode res = null;
        // 前一个节点
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 找到树中最小的节点（最左的子树）
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 如果上一个节点不存在，表明是链表的开头节点
                if (pre == null) {
                    pre = cur;
                    res = pre;
                } else {
                    // 上一个节点的right指向后一个节点
                    pre.right = cur;
                    // 后一个节点的left指向上一个节点
                    cur.left = pre;
                    // 保留上一个节点
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
