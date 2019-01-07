## 复杂链表的复制

### 题目描述

输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。

### 思路

可以分为三步：
1. 复制每个节点，并插入到被复制节点的后面。比如1->2->3 clone 1->1->2->2->3->3
2. 复制随机节点。当遍历到的当前节点存在随机节点时，则其复制节点也应该存在随机节点。比如当前节点`cur.random != null`，则`RandomListNode clone = cur.next;clone.random = cur.random.next;`
3. 分离两个链表。其中奇数链表为原链表，偶数链表为复制的链表

### 方法

```java
public class Solution {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        // clone original linkedList
        // for example,1->2->3 clone 1->1->2->2->3->3
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode cloneNode = new RandomListNode(cur.label);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        // clone random
        cur = pHead;
        while (cur != null) {
            RandomListNode cloneNode = cur.next;
            RandomListNode randomNode = cur.random;
            if (randomNode != null) {
                cloneNode.random = randomNode.next;
            }

            cur = cloneNode.next;
        }

        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode cloneNode = cur.next;
            // sub odd list and even list
            cur.next = cloneNode.next;
            cur = cloneNode;
        }

        return cloneHead;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
