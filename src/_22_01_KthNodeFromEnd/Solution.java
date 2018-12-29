package _22_01_KthNodeFromEnd;

import pojo.ListNode;
import utils.ListNodeUtil;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/29
 */
public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode fast = head;
        // 先走k-1步
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // k-1超出了链表长度
                return null;
            }
        }

        // 一起走k步
        ListNode slow = head;
        // fast走到末尾，并非走完
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("原链表为:" + ListNodeUtil.print(head));

        // k在头部，即k=1
        int k = 1;
        ListNode newHead = solution.FindKthToTail(head, k);
        System.out.println("倒数第" + k + "个节点为:" + ListNodeUtil.print(newHead));

        // k在尾部，即k=6
        k = 6;
        newHead = solution.FindKthToTail(head, k);
        System.out.println("倒数第" + k + "个节点为:" + ListNodeUtil.print(newHead));

        // k > 6
        k = 7;
        newHead = solution.FindKthToTail(head, k);
        System.out.println("倒数第" + k + "个节点为:" + ListNodeUtil.print(newHead));

        // k < 1
        k = 0;
        newHead = solution.FindKthToTail(head, k);
        System.out.println("倒数第" + k + "个节点为:" + ListNodeUtil.print(newHead));

    }
}
