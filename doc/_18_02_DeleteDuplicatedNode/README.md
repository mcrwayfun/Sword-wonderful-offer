## 删除链表中重复的节点

### 题目描述

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，**重复的结点不保留**，返回链表头指针。 例如，链表`1->2->3->3->4->4->5` 处理后为 `1->2->5`。


### 思路1

定义一个prev节点，用于标识前一个节点。


### 方法1

```java
public class Solution {

    /**
     * 删除重复节点，重复节点不保留
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = pHead;
        while (cur != null) {

            if (cur.next != null && cur.val == cur.next.val) {
                // 存在连续重复情况，比如1->2->2->2->3
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 存在2->2->2这种情况
                if (prev == null) {
                    pHead = cur.next;
                } else {
                    // 指向不重复的值
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        return pHead;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)