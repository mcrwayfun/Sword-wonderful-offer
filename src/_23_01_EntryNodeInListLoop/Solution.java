package _23_01_EntryNodeInListLoop;

import pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/30
 * @description 求链表环的入口，若没有环，返回null
 */
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
