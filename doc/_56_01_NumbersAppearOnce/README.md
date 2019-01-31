## 数组中只出现一次的两个数字

### 题目描述

一个整型数组里除了两个数字之外，其他的数字都出现了两次。

请写程序找出这两个只出现一次的数字。

你可以假设这两个数字一定存在。

```
输入：[1,2,3,3,4,4]

输出：[1,2]
```

### 思路1

如果数组中仅有一个不同的数字，那么可以使用异或的方法将这个数字找出来。如果存在两个不同的数字，则结果就是两个不同数字异或的来，而这个结果必定存在1。我们假定这1位于第n位（从左向右，从0开始计算），那么我们可以将数组分为两部分。一部分都是第n位为1的数字，而另一部分则是第n位为0的数字。如此，我们就分别对这两部分求得不同数。


```java
public class Solution {
    
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        // 数组进行异或操作，找到两个不同数的异或结果
        int xor = 0;
        for (int x : array) {
            xor = xor ^ x;
        }

        // 找出结果数中第一个为1的位置（从左向右）
        int index = findFirst1(xor);
        // 将数组分为两个部分，其中index位为1的为一组，index为0的为一组
        for (int x : array) {
            if (isBit1(x, index)) {
                num1[0] = num1[0] ^ x;
            } else {
                num2[0] = num2[0] ^ x;
            }
        }
    }

    /**
     * 找出结果数中第一个为1的位置（从左向右）
     *
     * @param xor
     * @return
     */
    private int findFirst1(int xor) {

        int index = 0;

        while ((xor & 1) == 0) {
            xor = xor >> 1;
            index++;
        }

        return index;
    }

    private boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}
```
- time complexity:O(n)
- space complexity:O(1)

