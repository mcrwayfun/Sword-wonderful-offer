## 链表中环的入口结点

### 题目描述

给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出`null`。

### 思路

![](https://ws1.sinaimg.cn/large/0062R7s4gy1fyp90id12wj30gb09ct9z.jpg)

1. 定义两个指针，分别为p1和p2。p1每次走两步，p2每次走一步，如果p1能够与p2相遇，则说明链表中存在环，且此时相遇点必定在环内（上图的节点5为p1和p2相遇点）；否则链表中不存在环。
2. 记录p1的位置，p2则重置到开头。当p1和p2再次相遇时，此时的相遇点必定为入环口。


### 方法

```java
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean hasCycle = false;
        // fast每次走两步，slow每次走一步，若有环则它们会相遇
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        // 没有环
        if (!hasCycle) {
            return null;
        }

        slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
