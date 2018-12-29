## 调整数组顺序使奇数位于偶数前面

### 题目描述

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，**并且奇数偶数的相对位置不变**。


### 思路

z这道题是题21-1的变形，其要求奇偶数的相对位置不变，面试时问清楚面试官，对时间和空间是否有要求。如果只允许增加额外空间，则只能使用二重循环的方式；如果能够接受额外空间，则时间复杂度可以达到O(n)。

思路为：

1. 统计奇数出现的次数oddCount
2. 复制一个新的数组bak
3. 遍历bak，定义两个指针`i = 0,j = oddCount `，如果value是奇数则`array[i++] = value`，否则`array[j++] = value`


### 方法

```java
public class Solution {

    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int oddCount = 0;
        // 统计奇数的个数
        for (int x : array) {
            if ((x & 1) == 1) {
                oddCount++;
            }
        }

        int[] bak = Arrays.copyOf(array, array.length);
        int i = 0, j = oddCount;
        for (int x : bak) {
            if ((x & 1) == 1) {
                array[i++] = x;
            } else {
                array[j++] = x;
            }
        }

    }
}
```

- time complexity:O(n)
- space complexity:O(n)
