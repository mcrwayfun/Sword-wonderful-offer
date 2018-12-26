## 数值的整数次方

### 题目描述

给定一个 `double` 类型的浮点数 `base` 和 `int` 类型的整数 `exponent`。求 `base`的 `exponent` 次方。

**注意**：在java语言中，`1.0/0`并不会报错，因为浮点数有INFINITY和NaN这两种概念。其中INFINITY是无限的意思，在Double中这么定义：

```java
    /**
     * A constant holding the positive infinity of type
     * {@code double}. It is equal to the value returned by
     * {@code Double.longBitsToDouble(0x7ff0000000000000L)}.
     */
    public static final double POSITIVE_INFINITY = 1.0 / 0.0;

    /**
     * A constant holding the negative infinity of type
     * {@code double}. It is equal to the value returned by
     * {@code Double.longBitsToDouble(0xfff0000000000000L)}.
     */
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
```

NaN的意思为Not A Number，即不是一个数字，在Double中这么定义

```java
    /**
     * A constant holding a Not-a-Number (NaN) value of type
     * {@code double}. It is equivalent to the value returned by
     * {@code Double.longBitsToDouble(0x7ff8000000000000L)}.
     */
    public static final double NaN = 0.0d / 0.0;
```

虽然不会报错，但还是要检验base是否为0，让我们自己做错误检测，而非交给程序得到意料外的答案。


### 思路1

1. 检测base是否为0，若是则直接返回base
2. 对exponent去绝对值，并进行exponent次的循环求得`result = result * base`
3. 若exponent小于0，即指数小于0，则对result取反；否则直接返回result


### 方法1

```java
    public double power(double base, int exponent) {

        // base为0，返回0
        if (base == 0.0) {
            return base;
        }

        double result = 1.0;
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++) {
            result *= base;
        }

        return exponent > 0 ? result : 1.0 / result;
    }
```

time complexity:O(n)
space complexity:O(1)
