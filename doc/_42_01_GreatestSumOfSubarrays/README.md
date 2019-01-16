## 连续子数组的最大和

### 题目描述

输入一个**非空**整型数组，数组里的数可能为正，也可能为负。 数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为`O(n)`。

### 思路

定义两个变量，其中 `max` 用来最大值，`curNum` 用来存储当前的相加值。如果 `curNum < 0` ，则直接将 `curNum = array[i]` ，因为 `负数 + array[i] < array[i]` ，否则 `curNum = curNum + array[i]` 

### 方法

```java
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int curNum = 0;
        for (int x : array) {

            if (curNum < 0) {
                curNum = x;
            } else {
                curNum += x;
            }

            max = Math.max(max, curNum);
        }

        return max;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
