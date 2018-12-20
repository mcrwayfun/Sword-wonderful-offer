package _09_01_QueueWithTwoStacks;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
public class Solution {

    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    public void push(int value) {
        stack1.push(value);
    }

    public int pop() {
        // stack2为空，可以往stack2插入元素
        if (stack2.isEmpty()) {
            // stack1为空，无元素pop
            if (stack1.isEmpty()) {
                throw new IllegalStateException("cannot pop element form empty queue !");
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        // 往空的队列里添加、删除元素
        Solution solution = new Solution();
        // stack1:tail[1->2->3->4->5]
        for (int i = 1; i <= 5; i++) {
            solution.push(i);
        }

        System.out.println(solution.pop());
    }
}
