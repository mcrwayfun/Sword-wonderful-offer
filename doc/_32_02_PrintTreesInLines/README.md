## 把二叉树打印成多行

### 题目描述

从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

### 思路
相比于上一道题，统计当前队列中存在的元素（同一层的元素会存在队列中），进行遍历并输出到一个列表中

### 方法

```java
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> reList = new ArrayList<>();

        if (pRoot == null) {
            return reList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {

            int level = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
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

            reList.add(list);
        }

        return reList;
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
