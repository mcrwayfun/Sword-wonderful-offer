## 把数组排成最小的数

### 题目描述

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

例如输入数组 `[3, 32, 321]`，则打印出这3个数字能排成的最小数字`321323`。

### 思路

将数字两两进行拼接，比如m和n，如果mn>nm，则n应该排列在m前面。用整型存放拼接数字可能会造成溢出，所以使用字符来表示。

### 方法

```java
public class Solution {

    public String printMinNumber(int[] nums) {

        StringBuilder res = new StringBuilder();
        if (nums == null || nums.length == 0) {
            return res.toString();
        }

        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Arrays.sort采用的是快排，默认升序
        // 如果str1+str2 > str2+str1，则两者交换
        Arrays.sort(strNums,
                (str1, str2) -> (str1 + str2).compareTo(str2 + str1));

        for (String str : strNums) {
            res.append(str);
        }

        return res.toString();
    }
}
```

- time complexity:O(nlogn)
- space complexity:O(1)
