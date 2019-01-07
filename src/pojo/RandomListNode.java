package pojo;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/7
 */
public class RandomListNode {

    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
        this.next = null;
        this.random = null;
    }
}
