## 包含min函数的栈

### 题目描述

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

### 思路
判断当前弹出序列，对于压入序列而言：
- 如果当前是栈顶元素，则直接弹出
- 如果栈为空或者不是栈顶元素，则把压入序列中还未入栈的元素压入栈，直到待弹出的元素压入栈
- 如果所有数字都压入栈后还未找到下一个弹出的数字，则不可能是弹出序列

### 方法

```java
public class Solution {

    /**
     * 判断是否是弹出序列
     *
     * @param pushA 压栈序列
     * @param popA  弹栈序列
     * @return 是否是弹出序列
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA == null || popA == null
                || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        // 序列栈pushA下标
        int index = 0;
        // popA数组长度
        int length = popA.length - 1;
        // 结束while循环flag
        boolean flag = false;

        for (int value : popA) {
            // 栈顶元素不是弹出元素
            while (stack.isEmpty() || stack.peek() != value) {
                // 如果越界则返回
                if (index > length) {
                    flag = true;
                    break;
                }
                stack.push(pushA[index++]);
            }

            // 不是遇到栈顶元素，数组越界结束的循环，则break
            if (flag) {
                break;
            }

            // 前弹出元素是序列栈栈顶元素，则直接弹出
            stack.pop();
        }

        return stack.isEmpty();
    }
}
```

- time complexity:O(n^2)
- space complexity:O(n)
