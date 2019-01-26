package _52_01_FirstCommonNodesInLists;

import pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/26
 * @description
 */
public class Solution {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int aLength = getListNodeLength(pHead1);
        int bLength = getListNodeLength(pHead2);
        if (aLength - bLength >= 0) {
            pHead1 = runK(pHead1, aLength - bLength);
        } else {
            pHead2 = runK(pHead2, bLength - aLength);
        }

        return getFristCommonNode(pHead1, pHead2);
    }

    private int getListNodeLength(ListNode head) {

        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }

    private ListNode runK(ListNode head, int k) {

        while (k != 0) {
            head = head.next;
            k--;
        }

        return head;
    }

    private ListNode getFristCommonNode(ListNode headA, ListNode headB) {

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
