## 从上到下打印二叉树

### 题目描述

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

### 思路
这道题考察的是BFS算法，我们使用一个队列来存储同层元素（先进先出）

### 方法

```java
public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 进行BFS
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                list.add(node.val);
            }
        }

        return list;
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
