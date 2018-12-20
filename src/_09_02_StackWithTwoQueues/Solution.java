package _09_02_StackWithTwoQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/20
 */
public class Solution {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int value) {
        queue1.offer(value);
    }

    public int pop() {

        if (queue1.isEmpty()) {
            throw new IllegalStateException("cannot get element from empty queue !");
        }

        // 往queue2中插入元素，直到queue1中只剩下一个需要pop的元素
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int val = queue1.poll();

        // 将queue2变为queue1
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

        return val;
    }

    public static void main(String[] args) {
        // 往空的栈里添加、删除元素
        Solution solution = new Solution();
        for (int i = 1; i <= 5; i++) {
            solution.push(i);
        }

        System.out.println("压栈=Head[1,2,3,4,5]");

        for (int i = 1; i <= 5; i++) {
            System.out.println("pop第" + i + "次:" + solution.pop());
        }
    }
}
