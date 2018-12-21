## 斐波那契数列

### 题目描述

斐波那契数列数学公式可以概括为：

![](https://ws1.sinaimg.cn/large/0062R7s4gy1fye664jcvtj30e104lwei.jpg)

### 思路1

使用递归，虽然代码简单，但是当n非常大时，容易造成栈溢出

### 思路2

使用循环来求值，利用两个变量来表示f(n-1)和f(n-2)

### 方法1

```java
public class Solution {

    public int Fibonacci(int n) {
        // n = 0, fn = 0
        // n = 1, fn = 1
        // n > 1, fn = f(n-1) + f(n - 2);
        if (n < 2)
            return n;

        int numberOne = 0;
        int numberTwo = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
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