## 数组中唯一出现一次的数字

### 题目描述

在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。

请找出那个只出现一次的数字。

你可以假设满足条件的数字一定存在。

### 思路1

遍历数组，求得每一个数对应的位数和并存入32位的数组中。遍历32位的数组，如果i位对应的和**不能**够被3整除，说明出现一次的数字的对应位数为1；否则为0


```java
public class Solution {
    
    public int findNumberAppearingOnce(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        // 存储每个数对应的位数和
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            for (int j = 0; j < 32; j++) {
                // 获取value每一位数，并求和
                bitSum[j] += value & 1;
                value = value >> 1;
            }
        }

        int retValue = 0;
        for (int i = 0; i < 32; i++) {
            // 如果不能被3整除，说明出现一次的数字的对应位数为1
            if (bitSum[i] % 3 != 0) {
                retValue += Math.pow(2, i);
            }
        }

        return retValue;
    }
}
```
- time complexity:O(n)
- space complexity:O(1)

