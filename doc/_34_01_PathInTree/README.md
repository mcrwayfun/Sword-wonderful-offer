## 二叉树中和为某一值的路径

### 题目描述

输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

### 思路

使用前序遍历，用一个list来记录经过的路径。每经过一个节点时，target减去当前节点值并且将root.val加入list中。
当target为0且当前节点是叶节点时，就将list加入到的reList中；否则递归遍历左子树和右子树。若当前节点不满足要求，在返回父节点前，需要将
当前节点从list中删除。

### 方法

```java
public class Solution {

    private ArrayList<ArrayList<Integer>> reList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return reList;
        }

        // find the path
        findPath(root, target, new ArrayList<>());

        return reList;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        target -= root.val;
        // if target is 0 and the node is leaf node
        if (target == 0 && root.left == null && root.right == null) {
            reList.add(new ArrayList<>(list));
        } else {
            // recursive the tree
            findPath(root.left, target, list);
            findPath(root.right, target, list);
        }

        // remove the last element
        list.remove(list.size() - 1);
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
