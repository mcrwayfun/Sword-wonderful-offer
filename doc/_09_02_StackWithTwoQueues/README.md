## 用两个队列实现栈

### 题目描述

用两个队列来实现一个栈，完成栈的 `Push` 和 `Pop` 操作。 栈中的元素为 `int` 类型。

### 思路1

栈的特性是先进后出（FILO），队列的特性是先进先出（FIFO）

现有两个队列，queue1和queue2。queue1用作压入和推出元素，而queue2用来暂存元素

入队操作：直接往queue1中offer元素

出队操作：如果queue1不为空，且queue1中有n个元素

1. 将queue1中n-1个元素压入到queue2中，留下一个队头元素（即将推出栈的元素）
2. 记录推出栈的元素`int val = queue1.poll`
3. 将queue1和queue2指针交换

### 方法1

```java
public class Solution {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int value) {
        queue1.offer(value);
    }

    public int pop() {

        if (queue1.isEmpty()) {
            throw new IllegalStateException("cannot get element from empty queue !");
        }

        // 往queue2中插入元素，直到queue1中只剩下一个需要pop的元素
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int val = queue1.poll();

        // 将queue2变为queue1
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

        return val;
    }
}
```
