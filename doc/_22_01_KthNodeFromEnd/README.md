## 链表中倒数第k个结点

### 题目描述

输入一个链表，输出该链表中倒数第k个结点。

### 思路

1. 定义一个fast指针，让其先走k-1步（注意判断若链表长度没有k长，则返回null）
2. 定义一个slow指针，和fast一起走。当fast走到末尾时，slow就走到了倒数第k个节点


### 方法

```java
public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode fast = head;
        // 先走k-1步
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // k-1超出了链表长度
                return null;
            }
        }

        // 一起走k步
        ListNode slow = head;
        // fast走到末尾，并非走完
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
