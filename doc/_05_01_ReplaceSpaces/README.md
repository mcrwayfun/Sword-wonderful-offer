## 替换空格

### 题目描述

请实现一个函数，将一个字符串中的每个空格替换成 `%20`。例如，当字符串为 `We Are Happy`，则经过替换之后的字符串为 `We%20Are%20Happy`。。

### 思路1

1. 遍历新创建的StringBuilder，遇到空格字符则append连个空字符到字符串末尾
2. 定义两个指针，p指向原字符串末尾，q指向新的字符串末尾
3. 当`p != q`，执行循环体：获取p对应的字符ch，如果`ch == ' '`，则从q位置开始依次append '02%'；若不是空格，则直接append ch

### 方法1

```java
public class Solution {

    public String replaceSpace(String str) {
        if (str == null || str.length() == 0)
            return null;

        StringBuilder stringBuilder = new StringBuilder(str);
        // 遍历str，遇到空格则新增两个空字符
        int len = stringBuilder.length();
        for (int i = 0; i < len; i++) {
            if (stringBuilder.charAt(i) == ' ')
                stringBuilder.append("  ");
        }

        // 定义两个指针
        // p指针指向原字符串末尾
        int p = len - 1;
        // q指针指向现有指针末尾
        int q = stringBuilder.length() - 1;

        while (p != q) {
            char ch = stringBuilder.charAt(p--);
            if (ch == ' ') {
                stringBuilder.setCharAt(q--, '0');
                stringBuilder.setCharAt(q--, '2');
                stringBuilder.setCharAt(q--, '%');
            } else {
                stringBuilder.setCharAt(q--, ch);
            }
        }

        return stringBuilder.toString();
    }
}
```

- time complexity：O(n)
- space complexity：O(n)