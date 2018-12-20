## 用两个栈实现队列

### 题目描述

用两个栈来实现一个队列，完成队列的 `Push` 和 `Pop` 操作。 队列中的元素为 `int` 类型。

### 思路1

栈的特性是先进后出（FILO），队列的特性是先进先出（FIFO）

入队操作：直接往stack1中push元素

出队操作：如果stack2为空且stack1不为空，则把stack1中的所有元素push进stack2中。此时慢进的元素反而在stack2的栈顶，先进的在stack2的栈底。然后执行stack2的pop操作，推出元素。

### 方法1

```java
public class Solution {

    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public void push(int value) {
        stack1.push(value);
    }

    public int pop() {
        // stack2为空，可以往stack2插入元素
        if (stack2.isEmpty()) {
            // stack1为空，无元素pop
            if (stack1.isEmpty()) {
                throw new IllegalStateException("cannot pop element form empty queue !");
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
```
