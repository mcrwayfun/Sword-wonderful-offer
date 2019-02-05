package _59_01_MaxInSlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/05
 * @description
 */
public class Solution {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> reList = new ArrayList<>();
        if (num == null || num.length < size || size < 1) {
            return reList;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {

            // 对尾元素比要入队的元素小，则把其移除（因为不可能成为窗口最大值）
            while (!deque.isEmpty() && num[deque.getLast()] <= num[i]) {
                System.out.println("当前队头元素为：" + num[deque.getFirst()]);
                System.out.println("需要入队的元素为：" + num[i] + "，出队的元素为：" + num[deque.getLast()]);
                deque.pollLast();
            }
            // 队首下标对应的元素不在窗口内，将其从队列中移除
            while (!deque.isEmpty() && (i - deque.getFirst() + 1 > size)) {
                System.out.println("队首下标" + deque.getFirst() + "对应的元素" + num[i] + "不在窗口中");
                deque.pollFirst();
            }
            // 把每次滑动的值加入到队列中
            System.out.println("即将加入队列中的值" + num[i]);
            deque.add(i);
            System.out.println("当前队列中的值" + deque);
            // 滑动窗口的首地址i大于等于size就写入窗口最大值
            if (!deque.isEmpty() && i + 1 >= size) {
                System.out.println("滑动窗口首地址i=" + i);
                reList.add(num[deque.getFirst()]);
                System.out.println("输出的列表reList" + reList);
            }

            System.out.println("==============================");
        }

        return reList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> integers = new Solution().maxInWindows(nums, size);
        for (int x : integers) {
            System.out.println(x);
        }
    }
}
