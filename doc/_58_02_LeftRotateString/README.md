### 翻转单词顺序

### 题目描述

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。

请定义一个函数实现字符串左旋转操作的功能。

比如输入字符串 `"abcdefg"` 和数字 2，该函数将返回左旋转 2 位得到的结果 `"cdefgab"`。

样例：

```
输入："abcdefg" , n=2

输出："cdefgab"
```

### 思路1

假设现在有字符串 `abcdefg` ，需要左移2位，变成`cdefgab` ，现在进行以下3个步骤：

1. 对前面n部分进行翻转，则有 `bacdefg`
2. 对剩余部分进行翻转，则有 `bagfedc`
3. 对整个字符串进行翻转，则有 `cdefgab`


```java
public class Solution {
    
    public String LeftRotateString(String str, int n) {

        if (str == null || str.length() == 0
                || str.trim().equals("") || n < 1 || n > str.length()) {

            return str;
        }

        char[] chars = str.toCharArray();
        // 翻转前面n部分
        reverse(chars, 0, n - 1);
        // 翻转剩余的部分
        reverse(chars, n, chars.length - 1);
        // 整体翻转
        reverse(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {

        if (chars == null || chars.length == 0) {
            return;
        }

        while (start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }
}
```
- time complexity:O(n)
- space complexity:O(n)

### 举一反三

假设现在有字符串 `abcdefg` ，需要**右移**2位，变成`fgabcde` ，现在进行以下3个步骤：

1. 字符串整体翻转，则有 `gfedcba` 
2. 翻转前面的n部分，则有 `fgedcba`
3. 翻转剩余的部分，则有 `fgabcde`

```java
public class Solution{
    
    public String RightRotateString(String str, int n) {

        if (str == null || str.length() == 0
                || str.trim().equals("") || n < 1 || n > str.length()) {

            return str;
        }

        char[] chars = str.toCharArray();
        // 整体翻转
        reverse(chars, 0, chars.length - 1);
        // 翻转前面n部分
        reverse(chars, 0, n - 1);
        // 翻转剩余的部分
        reverse(chars, n, chars.length - 1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {

        if (chars == null || chars.length == 0) {
            return;
        }

        while (start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }
}
```

- time complexity:O(n)
- space complexity:O(n)