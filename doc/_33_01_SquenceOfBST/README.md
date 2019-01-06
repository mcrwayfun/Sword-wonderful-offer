## 二叉搜索树的后序遍历序列

### 题目描述

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出`Yes`,否则输出`No`。假设输入的数组的任意两个数字都互不相同。

### 思路

后序遍历中，最后一个节点是根节点，由此可以判断：

- 遍历数组，找到左子树的下标（二叉搜索树的特性：左子树的值都比根节点小）
- 由左子树确定右子树下标，从该下标遍历数组，判断是否每个值都大于根节点
- 递归判断

### 方法

```java
public class Solution {

    public boolean VerifySquenceOfBST(int[] sequence) {

        // assert sequence is not null or empty
        if (sequence == null || sequence.length < 1) {
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {

        if (start >= end) {
            return true;
        }

        // left is smaller than root
        int left = start;
        while (left <= end) {
            // find the first right val
            if (sequence[left] >= sequence[end]) {
                break;
            }
            left++;
        }

        // right is bigger than root
        int right = left;
        while (right < end) {
            if (sequence[right] < sequence[end]) {
                return false;
            }
            right++;
        }

        return verify(sequence, start, left - 1) && verify(sequence, left, end - 1);
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
