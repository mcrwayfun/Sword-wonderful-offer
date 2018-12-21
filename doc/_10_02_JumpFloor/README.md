## 跳台阶

### 题目描述

一只青蛙一次可以跳上`1`级台阶，也可以跳上`2`级。求该青蛙跳上一个`n`级的台阶总共有多少种跳法（先后次序不同算不同的结果），数学公式可以概括为

```
// n = 1,fn = 1
// n = 2,fn = 2（每次跳一级台阶，或者一次跳二级台阶）
// n > 2,fn = f(n-1)+f(n-2)
```

### 思路1

使用递归，虽然代码简单，但是当n非常大时，容易造成栈溢出

### 思路2

使用循环来求值，利用两个变量来表示f(n-1)和f(n-2)

### 方法1

```java
public class Solution {

    public int JumpFloor(int target) {
        // n = 1,fn = 1
        // n = 2,fn = 2（每次跳一级台阶，或者一次跳二级台阶）
        // n > 2,fn = f(n-1)+f(n-2)
        if (target < 3)
            return target;

        int numberOne = 1;
        int numberTwo = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = numberOne + numberTwo;
            numberOne = numberTwo;
            numberTwo = result;
        }

        return result;
    }
}
```

time complexity:O(n)

space complexity:O(1)