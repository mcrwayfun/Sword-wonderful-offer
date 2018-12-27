## 打印从 1 到最大的 n 位数

### 题目描述

输入数字 `n`，按顺序打印出从 `1` 最大的 `n` 位十进制数。比如输入 `3`，则打印出 `1、2、3` 一直到最大的 3 位数即 999。

注意，需要问面试官n的范围，或者对时间复杂度有没有要求。


### 思路1

如果没有说明n的范围，那么需要注意n的大小。即使使用long类型来存储数据，最多只有64位。所以在这里使用char数组来存储并输出相应的数字。数组中无数字的地方使用'0'来填充，，输出时注意去掉前面的0。


### 方法1

```java
public class Solution {

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] nums = new char[n];
        Arrays.fill(nums, '0');

        while (!overflow(nums)) {
            printNums(nums);
        }

    }

    private void printNums(char[] nums) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        // 排除0，判断当前需要输出的真正位数
        for (char c : nums) {
            if (c != '0') {
                break;
            }
            count++;
        }

        for (int i = count; i < nums.length; i++) {
            res.append(nums[i]);
        }

        System.out.println(res.toString());
    }

    /**
     * 判断是否有溢出
     *
     * @param nums
     * @return 溢出则返回true，否则返回false
     */
    private boolean overflow(char[] nums) {

        boolean isOverFlow = false;
        int length = nums.length;
        // 进位1
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i] - '0' + carry;
            // 判断当前位数是否需要进位
            if (num > 9) {
                // 判断是否达到n位数
                if (i == 0) {
                    isOverFlow = true;
                    break;
                }
                // 当前位清0，重新开始进行1-9的循环
                nums[i] = '0';
            } else {
                // 当前位加1，并进行打印
                nums[i]++;
                break;
            }
        }

        return isOverFlow;
    }

}
```

- time complexity:O(10^n)
- space complexity:O(n)