## 变态跳台阶

### 题目描述

一只青蛙一次可以跳上`1`级台阶，也可以跳上`2`级……它也可以跳上`n`级。求该青蛙跳上一个`n`级的台阶总共有多少种跳法，

```
f(n-1) = f(0) + f(1) + ... + f(n-2) ①

```

### 思路2

Math.pow

### 方法1

```java
public class Solution {

    public int JumpFloorII(int target) {
        // fn = 2^(n-1)
        return (int) Math.pow(2, target - 1);
    }
}
```

time complexity:O(n)

space complexity:O(1)