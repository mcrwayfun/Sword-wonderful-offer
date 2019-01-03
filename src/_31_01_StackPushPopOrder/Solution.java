package _31_01_StackPushPopOrder;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/3
 */
public class Solution {

    /**
     * 判断是否是弹出序列
     *
     * @param pushA 压栈序列
     * @param popA  弹栈序列
     * @return 是否是弹出序列
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA == null || popA == null
                || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        // 序列栈pushA下标
        int index = 0;
        // popA数组长度
        int length = popA.length - 1;
        // 结束while循环flag
        boolean flag = false;

        for (int value : popA) {
            // 栈顶元素不是弹出元素
            while (stack.isEmpty() || stack.peek() != value) {
                // 如果越界则返回
                if (index > length) {
                    flag = true;
                    break;
                }
                stack.push(pushA[index++]);
            }

            // 不是遇到栈顶元素，数组越界结束的循环，则break
            if (flag) {
                break;
            }

            // 前弹出元素是序列栈栈顶元素，则直接弹出
            stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        new Solution().IsPopOrder(pushA, popA);
    }
}
