package _18_02_DeleteDuplicatedNode;

import pojo.ListNode;
import utils.ListNodeUtil;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/28
 * @description
 */
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


    public static void main(String[] args) {
        // 中间存在重复的
        ListNode head = ListNodeUtil.createList(new int[]{1, 2, 2, 2, 5});
        System.out.println("删除重复前：" + ListNodeUtil.print(head));

        head = new Solution().deleteDuplication(head);
        System.out.println("删除重复后：" + ListNodeUtil.print(head));

        // 开头存在重复的
        head = ListNodeUtil.createList(new int[]{2, 2, 2, 5});
        System.out.println("删除重复前：" + ListNodeUtil.print(head));

        head = new Solution().deleteDuplication(head);
        System.out.println("删除重复后：" + ListNodeUtil.print(head));

        // 尾部是重复的
        head = ListNodeUtil.createList(new int[]{1, 2, 2, 2, 2});
        System.out.println("删除重复前：" + ListNodeUtil.print(head));

        head = new Solution().deleteDuplication(head);
        System.out.println("删除重复后：" + ListNodeUtil.print(head));

        // 全是重复的
        head = ListNodeUtil.createList(new int[]{2, 2, 2, 2, 2});
        System.out.println("删除重复前：" + ListNodeUtil.print(head));

        head = new Solution().deleteDuplication(head);
        System.out.println("删除重复后：" + ListNodeUtil.print(head));

        // 没有重复的
        head = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("删除重复前：" + ListNodeUtil.print(head));

        head = new Solution().deleteDuplication(head);
        System.out.println("删除重复后：" + ListNodeUtil.print(head));

    }
}
