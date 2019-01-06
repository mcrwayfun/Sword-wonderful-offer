## 按之字形打印二叉树	

### 题目描述

请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

如二叉树：

```
            1
    	   /  \
    	  2    3
    	 / \  / \
    	4  5 6   7
```

打印结果为：

```
1
3 2
4 5 6 7
```

### 思路

使用两个栈来实现该功能，当打印的层数为奇数层时，向stack1中按照从左到右将子树压入栈中（因为后进先出，打印时先打印右子树）；当层数为偶数时，想stack2中按照从右到左将子树压入栈中。

### 方法

```java
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> reList = new ArrayList<>();
        if (pRoot == null) {
            return reList;
        }

        // 使用两个栈来实现树的之字形打印
        // 奇数层，则先压入左子树，后右子树
        // 偶数层，则先压入右子树，后左子树
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        // 层数（从1开始）
        int level = 1;
        while (!stack.empty()) {

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            boolean isOdd = level % 2 == 1;
            int size = stack.size();
            ArrayList<Integer> list = new ArrayList<>();
            // 打印同一层的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                list.add(node.val);

                // 奇数
                if (isOdd) {
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                }
                // 偶数
                else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }
            }
            reList.add(list);
            level++;
            stack = stack1.empty() ? stack2 : stack1;
        }

        return reList;
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
