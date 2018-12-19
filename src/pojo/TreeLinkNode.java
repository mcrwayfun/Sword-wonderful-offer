package pojo;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/19
 */
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }


    @Override
    public String toString() {
        return val + "";
    }
}
