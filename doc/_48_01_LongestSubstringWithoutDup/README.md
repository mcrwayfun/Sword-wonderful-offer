## 最长不含重复字符的子字符串

### 题目描述

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

假设字符串中只包含从 a 到 z的字符。

### 思路

使用动态规划来解决该问题。定义数组`characters` 来存储字符出现的位置， `res[i]` 表示以 `chars[i]` 字符结尾最长不重复的字符串长度。对于`res[i]`，

- 如果当前字符`chars[i]` 以前没有出现过，即 `characters[chars[i] - 'a']）!= -1` ，则 `res[i] = res[i-1] + 1 `; 
- 如果`res[i]` 之前出现过，则获取它当前位置 `i` 与之前出现位置`index = characters[chars[i] - 'a']）`的距离 `distance = i - index` 和 `res[i-1]` 的大小
  - 如果 `distance > res[i-1]` ，则 `res[i] = res[i-1] + 1`
  - 如果 `distance <= res[i-1]` ，则 `res[i] = distance`

### 方法

```java
public class Solution {

    public int longestSubstringWithoutDuplication(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        // 字符出现的位置
        int[] characters = new int[26];
        // 使用-1填充
        Arrays.fill(characters, -1);
        // 计算结果
        int[] res = new int[chars.length];

        // 初始化第一个字符出现次数为1
        res[0] = 1;
        // 最长字符出现次数
        int maxLength = res[0];
        // chars数组中第一个字符出现的位置，从下标0开始计算
        characters[chars[0] - 'a'] = 0;

        for (int i = 1; i < chars.length; i++) {

            // 获取字符出现的下标
            int index = characters[chars[i] - 'a'];
            // 计算两个相同字符出现距离
            int distance = i - index;

            res[i] = (index == -1 || distance > res[i - 1]) ?
                    res[i - 1] + 1 : distance;
            // 计算最大值
            maxLength = Math.max(maxLength, res[i]);
            // 设置当前字符出现的位置
            characters[chars[i] - 'a'] = i;
        }

        return maxLength;
    }
}
```

- time complexity:O(n)
- space complexity:O(n)
