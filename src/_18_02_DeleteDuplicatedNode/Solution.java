package _18_02_DeleteDuplicatedNode;

import pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/28
 * @description
 */
public class Solution {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;
        dummyHead.next = cur;
        while (cur != null) {
            if(cur.next != null && cur.val == cur.next.val){
                // 存在连续重复情况，比如1->2->2->2->3
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                dummyHead.next = cur;
            }

            cur = cur.next;
        }

        return dummyHead.next;
    }

}
