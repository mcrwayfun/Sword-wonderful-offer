## 数组中出现次数超过一半的数字

### 题目描述

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

### 思路

次数超过一半的数字可以转换为求数组中出现次数最多的元素。可以定义一个 `times` 和 `num` ，其中 times 为数组中某个数出现的次数，num 表示当前出现次数最多的那个数。当遇到相同的数字时，则 times++，否则 times--。当 times 为0时，将下一个值作为出现次数最多的，并将 times设置为1。最后留下的 num 必定为数组中出现次数最多的那个元素。

### 方法

```java
public class Solution {

    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        // 记录某个数出现的次数
        int times = 1;
        int num = array[0];

        for (int i = 0; i < array.length; i++) {

            // 如果times为0，则num记录为新值，并把times设置为1
            if (times == 0) {
                num = array[i];
                times = 1;
            }
            // 如果当前值与上一个值（num）相等，则times++
            else if (num == array[i]) {
                times++;
            }
            // 否则times--
            else {
                times--;
            }
        }

        // 最后留下的num是出现次数最多的值
        // 判断num是否出现次数超过一半
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }

        return count > array.length / 2 ? num : 0;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
