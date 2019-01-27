## 数字在排序数组中出现的次数

### 题目描述

统计一个数字在排序数组中出现的次数。

例如输入排序数组 [1, 2, 3, 3, 3, 3, 4, 5] 和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
```
输入：[1, 2, 3, 3, 3, 3, 4, 5] ,  3

输出：4
```

### 思路1
这是一个排序数组，可以使用二分法来找到第一个k的位置以及最后一个k的位置，相减即可得到k的数量

```java
public class Solution {
    
    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int startK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);

        int number = 0;
        if (lastK > -1 && startK > -1) {
            number = lastK - startK + 1;
        }

        return number;
    }

    /**
     * 获取数组中第一个k的下标
     *
     * @param array 数组
     * @param k     k
     * @param start
     * @param end
     * @return 下标（不存在则返回-1）
     */
    private int getFirstK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        int data = array[middle];
        // 中间刚好是k
        if (data == k) {
            // 判断前面是否存在k
            if (middle > 0 && array[middle - 1] == k) {
                end = middle - 1;
            } else {
                return middle;
            }
        } else if (data > k) {
            // 第一个k在前半部分
            end = middle - 1;
        } else {
            start = middle + 1;
        }

        return getFirstK(array, k, start, end);
    }

    /**
     * 获取数组中最后一个k
     *
     * @param array 数组
     * @param k     k
     * @param start
     * @param end
     * @return 下标（不存在则返回-1）
     */
    private int getLastK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        int data = array[middle];

        if (data == k) {
            // 判断后面还有没有k
            if (middle < array.length - 1 && array[middle + 1] == k) {
                start = middle + 1;
            } else {
                return middle;
            }
        } else if (data > k) {
            // 最后一个k在前半部分
            end = middle - 1;
        } else {
            start = middle + 1;
        }

        return getLastK(array, k, start, end);
    }
}
```
- time complexity:O(logn)
- space complexity:O(1)
