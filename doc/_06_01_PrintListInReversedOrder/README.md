## 从尾到头打印链表

### 题目描述

输入一个链表，按链表值从尾到头的顺序返回一个 `ArrayList`。

### 思路1

遍历链表，每个链表结点值 `push` 进栈，最后将栈中元素依次 `pop` 到 `list` 中。

### 方法1

```java
public class Solution {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> reList = new ArrayList<>();
        if (listNode == null)
            return reList;

        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (!stack.empty()) {
            reList.add(stack.pop());
        }

        return reList;
    }
}
```

- time complexity：O(n)
- space complexity：O(n)