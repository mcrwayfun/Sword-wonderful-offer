package _24_01_ReverseList;

import pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/31
 * @description
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        // 前一个节点
        ListNode prev = null;
        // 当前节点
        ListNode cur = head;
        // 反转后的链表头
        ListNode reversedHead = null;

        while (cur != null) {
            // 下一个节点
            ListNode next = cur.next;

            // 到了末尾
            if (next == null) {
                reversedHead = cur;
            }

            // 转向
            cur.next = prev;
            // prev移动到当前节点
            prev = cur;
            // cur移动到下一个节点
            cur = next;
        }

        return reversedHead;
    }

}
