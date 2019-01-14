package _40_01_KLeastNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/14
 */
public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> reList = new ArrayList<>();

        // input为空或者input长度小于k或者k小于1
        if (input == null || input.length < k || k < 1) {
            return reList;
        }

        // 创建一个降序堆，最大元素排在队首
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int x : input) {

            // size少于k则直接向堆中添加元素
            if (maxHeap.size() < k) {
                maxHeap.add(x);
            } else {
                // 如果比队首元素下，则将队首移除并将x加入堆中
                if (maxHeap.peek() > x) {
                    maxHeap.poll();
                    maxHeap.add(x);
                }
            }
        }

        reList.addAll(maxHeap);

        return reList;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> integers = new Solution().GetLeastNumbers_Solution(input, 4);
        for (int x : integers) {
            System.out.println(x);
        }
    }
}
