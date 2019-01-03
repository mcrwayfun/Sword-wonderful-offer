## 包含min函数的栈

### 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。

```java
public class Solution{
    
        // 压栈操作
        public void push(int node) {
            
        }
        
        // 出栈操作
        public void pop() {
            
        }
    
        // 获取栈中最小值
        public int top() {
            
        }
    
        // 获取栈中最小值
        public int min() {
            
        }
}
```

### 思路

题目要求一个栈实现min方法返回最小值，则pop方法也是最小值。使用两个栈stack1和stack2。stack1正常压栈入栈，stack2用来进行最小值的操作。
当node入栈时，stack1正常入栈。此时，如果stack2为空或者stack2的栈顶元素比node大，则stack2.push(node)。
否则，stack2将栈顶元素重复入栈。min和pop则直接返回stack2的栈顶元素

### 方法

```java
public class Solution {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 压栈
     *
     * @param node 待压入的元素
     */
    public void push(int node) {
        stack1.push(node);
        // stack2为空或者stack2栈顶元素比node大则直接压入栈
        if (stack2.isEmpty() || stack2.peek() > node) {
            stack2.push(node);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    /**
     * 返回当前的最小值
     * @return 最小值
     */
    public int top() {
        return stack2.peek();
    }

    /**
     * O(1)获取栈中最小值
     *
     * @return 最小值
     */
    public int min() {
        return stack2.peek();
    }
}
```

- time complexity:O(1)
- space complexity:O(n)
