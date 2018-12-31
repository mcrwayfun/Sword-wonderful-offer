package _25_01_MergeSortedLists;

import pojo.ListNode;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/31
 * @description 合并两个排序的链表
 */
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
