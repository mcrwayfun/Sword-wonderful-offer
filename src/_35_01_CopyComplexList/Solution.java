package _35_01_CopyComplexList;

import pojo.RandomListNode;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/7
 */
public class Solution {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        // clone original linkedList
        // for example,1->2->3 clone 1->1->2->2->3->3
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode cloneNode = new RandomListNode(cur.label);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        // clone random
        cur = pHead;
        while (cur != null) {
            RandomListNode cloneNode = cur.next;
            RandomListNode randomNode = cur.random;
            if (randomNode != null) {
                cloneNode.random = randomNode.next;
            }

            cur = cloneNode.next;
        }

        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode cloneNode = cur.next;
            // sub odd list and even list
            cur.next = cloneNode.next;
            cur = cloneNode;
        }

        return cloneHead;
    }

    public static void main(String[] args) {
        RandomListNode listNode1 = new RandomListNode(1);
        RandomListNode listNode2 = new RandomListNode(2);
        RandomListNode listNode3 = new RandomListNode(3);
        RandomListNode listNode4 = new RandomListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        new Solution().Clone(listNode1);
    }
}
