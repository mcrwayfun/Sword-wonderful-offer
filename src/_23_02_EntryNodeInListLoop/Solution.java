package _23_02_EntryNodeInListLoop;

import pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/31
 * @description 返回环中节点个数，没有环则返回0
 */
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
