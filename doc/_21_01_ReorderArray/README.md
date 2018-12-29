## 调整数组顺序使奇数位于偶数前面

### 题目描述

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分


### 思路

定义两个指针`odd = 0`和`even = array.length - 1`，odd指向的值为偶数且even指向的值为奇数，则交换两个下标对应的值。


### 方法

```java
public class Solution {

    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int odd = 0, even = array.length - 1;
        while (odd < even) {

            // odd向后移动，直到遇见奇数
            while (odd < even && (array[odd] & 1) != 0) {
                odd++;
            }

            // even向前移动，直到遇到偶数
            while (odd < even && (array[even] & 1) != 1) {
                even--;
            }

            swap(array, odd, even);
        }
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
