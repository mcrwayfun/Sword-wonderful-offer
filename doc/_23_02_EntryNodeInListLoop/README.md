## 链表中环节点的个数

### 题目描述

给一个链表，若其中包含环，请找出该链表的环的节点个数，若不存在环则返回0

### 思路

![](https://ws1.sinaimg.cn/large/0062R7s4gy1fyp90id12wj30gb09ct9z.jpg)

1. 定义两个指针，分别为p1和p2。p1每次走两步，p2每次走一步，如果p1能够与p2相遇，则说明链表中存在环，且此时相遇点必定在环内（上图的节点5为p1和p2相遇点）；否则链表中不存在环。
2. 记录p1的位置，定义`count =1`，执行循环条件`p1.next != p1`直到回到原点。


### 方法

```java
public class Solution {

    public int EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return 0;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean hasCycle = false;
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
            return 0;
        }

        int count = 1;
        while (fast.next != fast) {
            count++;
            fast = fast.next;
        }

        return count;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
