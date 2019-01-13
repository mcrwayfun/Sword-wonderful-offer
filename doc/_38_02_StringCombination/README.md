## 字符串的排列-全组合

### 题目描述

对输入的字符求它的组合。输入3个字符a、b、c，则它们的组合有a、b、c、ab、ac、bc、abc。

### 思路

这道题可以使用位的思想来解决。a可以看作001（000无意义），则abc可以看作111，它的全组合则落在001~111中。全组合的个数为2^n-1。利用这个思路：

1. 求得字符数组长度`length = str.length` 和 组合个数 `all = 1 << length` （这里对1左移length，即求得2^n）
2. 外循环all次（001开始到111），内循环length次，分别对每位数进行与操作，并append到StringBuilder中，内循环结束一次则输出到结果list中。比如对111，此时外循环`i = 7` ，内循环的第1次 `j = 0` ，`1 << j = 001`，`111 & 001 = 001 != 0 ` 成立 ，所以append  `chars[j = 0] = a`；接着内循环的第2次循环，append ` chars[1] = b` 到 StringBuilder中，此时StringBuilder中为 `ab`；接着执行第3次循环，append c 到其中。内循环结束，执行外循环。

这道题的时间复杂度为 `length * all = n * 2^n `

### 方法

```java
public class Solution {

    public ArrayList<String> Combination(String str) {

        ArrayList<String> reList = new ArrayList<>();

        if (str == null || str.length() == 0) {
            return reList;
        }

        char[] chars = str.toCharArray();
        // 字符数组长度
        int length = chars.length;
        // 组合总数2^n = (1 << n)
        int all = 1 << length;

        // a从001开始，000无意义
        for (int i = 1; i < all; i++) {

            StringBuilder res = new StringBuilder();

            // 利用与&的性质，判断1
            // 输出001~111
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    res.append(chars[j]);
                }
            }

            reList.add(res.toString());
        }

        return reList;
    }
}
```

- time complexity:O(n*2^n)
- space complexity:O(1)
