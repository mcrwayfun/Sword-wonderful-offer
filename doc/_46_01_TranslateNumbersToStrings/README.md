## 把数字翻译成字符串

### 题目描述

给定一个数字，我们按照如下规则把它翻译为字符串：

0 翻译成 a，1 翻译成 b，……，11 翻译成 l，……，25 翻译成 z。

一个数字可能有多个翻译。例如 12258 有 5 种不同的翻译，它们分别是 ”bccfi”、”bwfi”、”bczi”、”mcfi”和”mzi”。

请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。

### 思路

使用动态规划的方法来获取总的翻译方法，如果当前字符和前一个字符能构成有效的翻译方式，则

- 能。res[i] = res[i-1] + res[i-2]
- 不能。res[i] = res[i-1]

### 方法

```java
public class Solution {

    public int getTranslationCount(String s) {

        if (s == null || s.length() < 2) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];

        res[0] = 1;
        res[1] = isInRange(chars[0], chars[1]) ? 2 : 1;
        for (int i = 2; i < chars.length; i++) {
            res[i] = res[i - 1] + (isInRange(chars[i - 1], chars[i]) ? res[i - 2] : 0);
        }

        return res[chars.length - 1];
    }

    /**
     * 判断是否处于[10,25]之间
     *
     * @param a
     * @param b
     * @return
     */
    private boolean isInRange(char a, char b) {
        int num = (a - '0') * 10 + (b - '0');
        return num >= 10 && num <= 25;
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
