## 表示数值的字符串

### 题目描述

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。


### 思路1

根据题目要求，输入的应该满足以下格式：

`[sign]integer-digits[.[fragment-digits]]integer-[e|E[sign]exponential-digits]`

其中[]表示可有可无。这道题要找到不符合输入格式的规则进行判断即可。

1. 遇到e或者E，后面不跟数字则不是数值
2. 存在两个e或者E，则不是数值
3. e的前面必须是数字
4. 第一次出现符号，且不在字符串开头，则必须要跟在e后面
5. 第二次出现符号，则必须在e后面（比如+-5这种是错误的）
6. 遇到小数点，若已经出现过e，则不是数值（因为e后面不可能有小数点）
7. 小数点出现两次，则不是数值
8. 出现非法字符（排除掉以上字符后，不是0~9的字符均为非法字符）


### 方法1

```java
    /**
     * 根据题目要求，输入的应该满足以下格式
     * [sign]integer-digits[.[fragment-digits]][e|E[sign]exponential-digits]
     * []中表示可有可无
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }
        // 分别标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                // e后面要有数字
                if (i == str.length - 1) {
                    return false;
                }
                // 不能同时存在两个e
                if (hasE) {
                    return false;
                }
                // e的前面必须是数字
                if (i > 0 && str[i - 1] < '0' || str[i - 1] > '9') {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第一次出现符号，且不在字符串开头，则必须要跟在e后面
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                // 第二次出现符号，则必须在e后面
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能有小数点，小数点不会出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            }
            // 非法字符
            else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }

        return true;
    }
```

- time complexity:O(n)
- space complexity:O(1)

### 思路2

表示数值的字符串遵循模式`A[.[B]][e|EC]`或者`.B[e|EC]`，其中A为数值的整数部分，B紧跟小数点为数值的小数部分，C紧跟着e或者E为数值的指数部分。上述A和C都有可能以 `+` 或者 `-` 开头的0~9的数位串，B也是0~9的数位串，但前面不能有正负号。

```java
public class Solution {

    private int index = 0;

    /**
     * 判断是否是数值
     * @param  str 
     * @return 
     */
    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        // 是否存在整数
        return start < index;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)