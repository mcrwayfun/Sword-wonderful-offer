## 剪绳子

### 题目描述

给你一根长度为`n`绳子，请把绳子剪成`m`段（`m`、`n`都是整数，`n>1`并且`m≥1`）。每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘积是多少？例如当绳子的长度是 8 时，我们把它剪成长度分别为 `2、3、3` 的三段，此时得到最大的乘积`18`。


### 思路1

动态规划法，问题可以归纳为`f(n) = max{f(n-i) × f(i)}, 0 < i < n`，即可以由子问题来解决。子问题最终可以分解为4个基础问题，即：

```java
// 求f(n)可以由以下这4个值构成
// 比如f(5) = f(2)*f(3)
result[0] = 0;
result[1] = 1;
result[2] = 2;
result[3] = 3;
```


### 方法1

```java
public class Solution {

    public int maxProductAfterCutting(int length) {

        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        // 结果集，数组下标为绳子长
        int[] result = new int[length + 1];

        // 求f(n)可以由以下这4个值构成
        // 比如f(5) = f(2)*f(3)
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        // result数组第i个元素表示把长度为i的切为若干段后乘积的最优解（从4开始算）
        // 因为已经排除了length < 4的情况
        for (int i = 4; i <= length; i++) {
            int max = 0;
            // 当前长度为i，j从1开始，表示剪成i->j-i段
            // 遍历求最大值
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, result[j] * result[i - j]);
            }
            result[i] = max;
        }

        return result[length];
    }
}
```

time complexity:O(n^2)
space complexity:O(n)