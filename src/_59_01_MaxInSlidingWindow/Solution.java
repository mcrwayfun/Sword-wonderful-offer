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
                deque.pollLast();
            }


        }

        return reList;
    }
}
