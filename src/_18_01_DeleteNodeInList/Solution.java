package _18_01_DeleteNodeInList;

import pojo.ListNode;
import utils.ListNodeUtil;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/27
 */
public class Solution {

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

    public static void main(String[] args) {
        // 删除中间节点
        ListNode head = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("head：" + ListNodeUtil.print(head));

        ListNode tobeDelete = head.next.next;
        System.out.println("tobeDelete：" + ListNodeUtil.print(tobeDelete));

        head = new Solution().deleteNode(head, tobeDelete);

        System.out.println("删除成功后：" + ListNodeUtil.print(head));

        // 删除末尾节点
        head = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("head：" + ListNodeUtil.print(head));

        tobeDelete = head.next.next.next.next;
        System.out.println("tobeDelete：" + ListNodeUtil.print(tobeDelete));

        head = new Solution().deleteNode(head, tobeDelete);

        System.out.println("删除成功后：" + ListNodeUtil.print(head));

        // 从只有一个节点的链表中删除节点
        head = ListNodeUtil.createList(new int[]{1});
        System.out.println("head：" + ListNodeUtil.print(head));

        tobeDelete = head;
        System.out.println("tobeDelete：" + ListNodeUtil.print(tobeDelete));

        head = new Solution().deleteNode(head, tobeDelete);

        System.out.println("删除成功后：" + ListNodeUtil.print(head));
    }
}
