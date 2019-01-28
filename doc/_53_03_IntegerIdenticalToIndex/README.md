## 数组中数值和下标相等的元素

### 题目描述

假设一个单调递增的数组里的每个元素都是整数并且是唯一的。

请编程实现一个函数找出数组中任意一个数值等于其下标的元素。

例如，在数组 [-3, -1, 1, 3, 5] 中，数字 3 和它的下标相等。

```
输入：[-3, -1, 1, 3, 5]

输出：3
```

### 思路1
可以使用二分法来解决问题。根据题目要求分析得出，如果当前下标大于元素值，则符合条件的元素在左边；
否则在右边。

```java
public class Solution {
    
    public int getNumberSameAsIndex(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int data = nums[mid];

            if (mid == data) {
                return data;
            } else if (mid > data) {
                // 下标大于元素值，则去右边找
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
```
- time complexity:O(logn)
- space complexity:O(1)

