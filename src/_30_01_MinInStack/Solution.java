package _30_01_MinInStack;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/3
 */
public class Solution {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 压栈
     *
     * @param node 待压入的元素
     */
    public void push(int node) {
        stack1.push(node);
        // stack2为空或者stack2栈顶元素比node大则直接压入栈
        if (stack2.isEmpty() || stack2.peek() > node) {
            stack2.push(node);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    /**
     * 返回当前的最小值
     * @return 最小值
     */
    public int top() {
        return stack2.peek();
    }

    /**
     * O(1)获取栈中最小值
     *
     * @return 最小值
     */
    public int min() {
        return stack2.peek();
    }
}
