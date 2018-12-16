## 找出数组中重复的数字

### 题目描述

在一个长度为 `n` 的数组里的所有数字都在 `0` 到 `n-1` 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为 `7` 的数组 `{2, 3, 1, 0, 2, 5, 3}`，那么对应的输出是重复的数字 `2` 或者 `3`。

### 思路1

将数组进行排序（Arrays.sort，使用归并，复杂度为O(nlogn)），然后进行一次遍历(复杂度为O(n))，就能很快的找到重复的数字，时间复杂度为O(nlogn)

### 思路2

使用哈希表（HashTable），遍历数组，如果哈希表中不存在该元素，则插入；否则返回重复元素。时间复杂度为O(n)，但是使用到了额外的结构，所以空间复杂度为O(n)

### 思路3

不利用额外的空间，且把时间复杂度控制在O(n)，思路与判断链表中是否存在环相似。

数组长度为n，且数字范围在0到n-1内，所以如果没有重复元素，则下标与数值一一对应。

现有下标为i，当前数值为num[i]，遍历数组。

1. 如果`i == num[i]`，则`i++`继续循环
2. 否则判断num[i]与其真正下标（即num[i]）对应的数值num[num[i]]是否相等。如果相等则说明有重复值（如有重复值则在先前遍历中已经将其交换到下标对应位置），则记录重复值并且返回true；否则交换下标i与下标num[i]对应的数。

当n足够大时，内层循环可以忽略不计。

### 方法

```java
public class Solution {

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 1)
            return false;

        for (int x : numbers)
            if (x < 0 || x >= length)
                return false;

        for (int i = 0; i < length; i++) {
            // 当前下标不等于当前值
            while (i != numbers[i]) {

                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                // 交换
                swap(numbers, numbers[i], i);
            }
        }

        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```


