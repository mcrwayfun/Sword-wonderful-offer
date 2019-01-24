## 第一个只出现一次的字符

### 题目描述

在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

### 思路1

因为字母区分大小写，所以声明一个包含大小写字母的int数组，用于统计字符出现的次数（因为数组长度固定，所以创建数组的空间复杂度可以认为是O(1)）。

```java
public class Solution {
    
    public int FirstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }

        char[] charArray = str.toCharArray();

        int[] result = new int['z' + 1];
        for (char c : charArray) {
            result[(int) c]++;
        }

        for (int i = 0; i < charArray.length; i++) {
            // 找到第一个为1的字符
            if (result[(int) charArray[i]] == 1) {
                return i;
            }
        }

        return -1;
    }
}
```
- time complexity:O(n)
- space complexity:O(1)
