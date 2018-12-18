package _06_01_PrintListInReversedOrder;

import pojo.ListNode;
import utils.ListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/18
 */
public class Solution {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> reList = new ArrayList<>();
        if (listNode == null)
            return reList;

        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (!stack.empty()) {
            reList.add(stack.pop());
        }

        return reList;
    }

    public static void main(String[] args) {

        // 功能测试（输入的链表有多个结点；）
        ListNode head = ListNodeUtil.createList(new int[]{1, 2, 3, 4, 5});
        ArrayList<Integer> retList = new Solution().printListFromTailToHead(head);
        System.out.println("链表" + ListNodeUtil.print(head) + "反序输出" + Arrays.toString(retList.toArray()));

        // 输入的链表只有一个结点
        head = ListNodeUtil.createList(new int[]{1});
        retList = new Solution().printListFromTailToHead(head);
        System.out.println("链表" + ListNodeUtil.print(head) + "反序输出" + Arrays.toString(retList.toArray()));

        // 特殊输入测试（输入的链表结点指针为空）
        head = null;
        retList = new Solution().printListFromTailToHead(head);
        System.out.println("链表" + ListNodeUtil.print(head) + "反序输出" + Arrays.toString(retList.toArray()));
    }
}
