## 二的整数次方

### 题目描述

输入一个整数，用一句话判断它是不是2的整数次方


### 思路1

一个整数如果是2的整数次方，那么它的二进制表达中有且仅有一位是1。


### 方法1

```java
public class Solution {

    public boolean powerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
```

time complexity:O(1)
space complexity:O(1)
