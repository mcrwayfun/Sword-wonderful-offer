### 翻转单词顺序

### 题目描述

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。

为简单起见，标点符号和普通字母一样处理。

例如输入字符串 `"I am a student."`，则输出 `"student. a am I"`。

### 思路1

先对整个字符串进行翻转，然后再对单词进行翻转（单词间使用空格区别）。注意，使用两个指针使用对最后一个单词进行单独处理。


```java
public class Solution {
    
    public String ReverseSentence(String str) {

        if (str == null || str.length() == 0) {
            return "";
        }

        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        // 翻转整个字符串
        reverse(chars, start, end);

        // 翻转单个字符
        start = 0;
        end = 0;
        while (end < chars.length) {

            if (chars[start] == ' ') {
                start++;
                end++;
            } else if (chars[end] == ' ') {
                reverse(chars, start, --end);
                // 下一个翻转单词起始
                start = ++end;
            } else {
                end++;
            }
        }
        // 对最后一个单词进行翻转
        reverse(chars, start, chars.length - 1);
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
- time complexity:O(n^2)
- space complexity:O(n)

### 思路2

使用java string的split和join进行处理。先分割后合并！注意排除全是空格的情况！

```java
public class Solution{
    
    public String ReverseSentence(String str) {

        // 当输入的str全是空格时，同样也要排除这种情况
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return str;
        }

        String[] splitArray = str.split(" ");
        reverse(splitArray, 0, splitArray.length - 1);

        return String.join(" ", splitArray);
    }

    private void reverse(String[] array, int start, int end) {

        if (array == null || array.length == 0) {
            return;
        }

        while (start <= end) {
            String temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
```

- time complexity:O(n)
- space complexity:O(n)