## 数字序列中某一位的数字

### 题目描述

数字以 `0123456789101112131415…` 的格式序列化到一个字符序列中。

在这个序列中，第 5 位（从 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。

请写一个函数求任意位对应的数字。

### 思路

举个例子，比如求序列第 1001 位。

序列的前 10 位是 `0~9`， 这 10 个只有一位的数字。显然第 1001 位在这 10 个数字之后，因此这 10 个数字可以直接跳过。再从后面序列中找第 991（991=1001-10） 位的数字。接下来有 90 个两位数，共 180 位，由于 991>180，所以继续跳过。从 881 找...最后可以找到对应的数字以及数字的某一位。

### 方法

```java
public class Solution {

    public int digitAtIndex(int n) {
        if (n < 0) {
            return -1;
        }

        int digits = 1;
        while (true) {
            // 根据位数判断当前是前几位
            // 比如1则是前10位，因为有0~9这10个数字，所以1*10=10
            // 比如2则是前180位，因为有10~99这90个数字，所以2*90=180
            long numbers = countOfIntegers(digits);

            // n是否在当前位数中
            if (n < digits * numbers) {
                break;
            }

            // 不在则n减去相应的位数
            n -= numbers * digits;
            digits++;
        }


        return digitAtIndex(digits, n);
    }

    private long countOfIntegers(int digits) {
        return digits == 1 ? 10 : (int) (9 * Math.pow(10, digits - 1));
    }

    private int digitAtIndex(int digits, int n) {
        // 获取m位数的第一个数字
        // 比如1位第一个数字是0，2位第一个数字是10
        int beginNumber = getBeginNumber(digits);
        // 获取这是哪个数，比如求第1001对应的数字，则此时n=811，digits=3,n/digits=270
        // val = 100+270=370，即第1001对应的那个数是370
        int val = beginNumber + n / digits;
        // 第1001位处于370的哪一位
        int indexFromRight = digits - n % digits;
        // 求出位数
        for (int i = 1; i < indexFromRight; ++i) {
            val /= 10;
        }
        return val % 10;
    }

    private int getBeginNumber(int digits) {
        return digits == 1 ? 0 : (int) Math.pow(10, digits - 1);
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
