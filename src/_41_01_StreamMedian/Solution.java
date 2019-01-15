package _41_01_StreamMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/15
 */
public class Solution {

    /**
     * 存放右边的数据（最小的数据比左边大）
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * 存放左边的数据（最大的数据比右边小）
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


    public void Insert(Integer num) {

        // 当前值小于最大堆的最大值
        if (maxHeap.size() > 0 && num < maxHeap.peek()) {
            maxHeap.offer(num);
            // 维持最大堆和最小堆size相差不超过1
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            // 维持最大堆和最小堆size相差不超过1
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public Double GetMedian() {

        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        // 如果元素总数是奇数（偶数则两个值应该相等）
        // 中位数位于最大堆
        if (maxSize > minSize) {
            return (double) (maxHeap.peek());
        }
        // 中位数位于最小堆
        if (minSize > maxSize) {
            return (double) (minHeap.peek());
        }

        // 元素总数是偶数
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
