## 在O(1)时间内删除链表节点

### 题目描述

给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。

需要注意的是：被删除的节点指针一定能在链表中找到


### 思路1

1. 如果被删除的节点不是尾节点，则可以把下一个节点覆盖被删除节点，并将删除节点的下下个节点指向当前被删除节点（`tobeDelete.next = tobeDelete.next.next`）
2. 如果链表中仅有一个节点，则将当前节点设置为null
3. 否则说明被删除节点是尾节点，不存在下一个节点，则需要通过遍历找到删除节点的前一个节点，再执行删除


### 方法1

```java
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return head;
        }

        // 删除的不是尾节点
        if (tobeDelete.next != null) {
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        }
        // 链表中仅有一个节点
        else if (head == tobeDelete) {
            head = null;
        }
        // 删除的是尾节点
        else {
            ListNode cur = head;
            while (cur.next != tobeDelete) {
                cur = cur.next;
            }
            cur.next = null;
        }

        return head;
    }
```

time complexity:O(1)，平均时间复杂度为O(1)
space complexity:O(1)
