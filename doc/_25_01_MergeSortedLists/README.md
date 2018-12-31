## 合并两个排序的链表

### 题目描述

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

### 思路

使用递归来解决


### 方法

```java
public class Solution {

    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode mergeList = null;
        if (list1.val < list2.val) {
            mergeList = list1;
            mergeList.next = Merge(list1.next, list2);
        } else {
            mergeList = list2;
            mergeList.next = Merge(list1, list2.next);
        }

        return mergeList;
    }
}
```

- time complexity:O(n)
- space complexity:O(1)
