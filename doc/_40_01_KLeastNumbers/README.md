## 最小的K个数

### 题目描述

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

### 思路

使用堆来解决这个问题。如果堆中元素少于4个，则直接向堆中添加元素；如果多于4个，且加入的元素e小于当前
堆首元素（最大堆），则将其从堆中删除并插入e。

### 方法

```java
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
}
```

- time complexity:O(nlogK)
- space complexity:O(k)
