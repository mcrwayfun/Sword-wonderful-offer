## 0到n-1中缺失的数字

### 题目描述

一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0 到 n-1 之内。

在范围 0 到 n-1 的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。

```
输入：[0,1,2,4]

输出：3
```

### 思路1
找出第一个与下标不对应的数字即可。

特殊情况：

- 下标都对应，那么应该返回 最后一个数+1；
- 缺失的数字是第一个，那么返回 0。

该算法无法针对输入数据无效的情况，比如输入`[0,1,2,5]`。如果需要对输入进行有效性的验证，那么时间复杂度会变为O(n)。

```java
public class Solution {
    
    public int getMissingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int data = nums[mid];
            if (data != mid) {
                // 前一个数字是相等的，则data是第一个不相等的数字
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    // 不相等的在前半部分
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        // 前面数字都相等，说明缺失的是最大的数字
        if (left == nums.length) {
            return nums.length;
        }

        // 无效输入
        return -1;
    }
}
```
- time complexity:O(logn)
- space complexity:O(1)

### 变形

如果输入的数组不是有序的，则使用不了二分法。此时有两种方法

1. 求出缺失元素的数组和，再求出不缺失的数组和，后者减去前者得到的就是缺失的数字。
2. 利用异或的特性，数组下标和数组元素进行异或，最后留下的就是缺失的元素。因为自己与自己异或会变为0，则有公式 ` a ^ b ^ b = a`

```java
public class Solution{
    
    public int getMissingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int xor = 0, i = 0;
        for (; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
```

