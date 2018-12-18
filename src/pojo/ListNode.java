package pojo;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/18
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("ListNode=[");
        ListNode current = next;
        while (current != null) {
            res.append(current.val + "->");
            current = current.next;
        }
        res.append("Null]");

        return res.toString();
    }
}
