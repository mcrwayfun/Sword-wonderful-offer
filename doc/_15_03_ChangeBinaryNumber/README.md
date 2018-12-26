## m改变多少次得到n

### 题目描述

输入连个整数m和n，计算需要改变m的二进制表示中的多少位可以得到n


### 思路1

m和n先进行异或操作，然后再统计1的个数


### 方法1

```java
public class Solution {
    
    public int changeNum(int m, int n) {
        // 进行异或（不同为1）
        int value = m ^ n;
        int count = 0;
        while (value != 0) {
            count++;
            value = value & (value - 1);
        }
        return count;
    }
}
```

time complexity:O(1)
space complexity:O(1)
