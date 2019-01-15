## 数据流中的中位数

### 题目描述

如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

### 思路

寻找中位数要在一个排好序的列表中寻找，使用两个堆（最大堆和最小堆）来解决问题，其中最大堆用来存储列表左边的数据，最小堆用来存储右边的数据，
所以最大堆的最大元素也比最小堆的最小元素要小。我们插入元素时，保证插入最大堆的元素必定比其堆顶元素小，否则将其插入到最小堆中。插入元素后，
两个堆都要调整数量，使得最大堆和最小堆的数量差维持在1。

### 方法

```java
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
```

- insert time complexity:O(logn)
- search time complexity:O(1)
- space complexity:O(n)
