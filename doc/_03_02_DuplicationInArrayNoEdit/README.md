## 找出数组中重复的数字

### 题目描述

在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果输入长度为 8 的数组 {2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字 2 或者 3。

### 思路1

使用哈希表（HashTable），遍历数组，如果哈希表中不存在该元素，则插入；否则返回重复元素。时间复杂度为O(n)，但是使用到了额外的结构，所以空间复杂度为O(n)

### 思路2

数组元素取值的范围为[1,n]，共有n+1个元素。

1. 将数组划分为[1,mid]和[mid+1,n]。

2. 计算数组中有多少个元素（count）在[1，mid]这个范围中。
3. 若count > (mid - left)+1，则说明左区间存在重复数字，则right = mid使得范围缩小；否则left = mid +1，将范围定位在右闭区间。
4. 重复执行知道left == right，判断count > 1是否成立，成立则返回left；否则break跳出循环并返回-1

### 思路3

使用链表快慢指针查找环的思路（必须确定存在重复数字，否则会报空指针）：

1. 数组的取值范围[1,n]，所以使用下标0作为起始索引
2. 快慢指针异步走，再次重逢时必定在环上
3. 重新设置一个指针，走相同的步数直至相遇，则相遇点为入环点

### 方法1

```java
// 使用思路2
public class Solution {


    public int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        for (int x : numbers)
            if (x < 1 || x > numbers.length - 1)
                return -1;

        // 值范围而不是下标范围
        int left = 1, right = numbers.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            int count = countRange(numbers, left, mid);
            if (left == right) {
                // 存在重复数字
                if (count > 1)
                    return left;

                break;
            } else {
                // 左区间count大于[left,mid]中本应存在的数
                if (count > (mid - left) + 1)
                    right = mid;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 统计数组值在[start,end]中的个数
     *
     * @param numbers 数组
     * @param start   左闭区间
     * @param end     右闭区间
     * @return
     */
    private int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int x : numbers) {
            if (x >= start && x <= end)
                count++;
        }
        return count;
    }
}
```

### 方法2

```java
public class Solution1 {

    public int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        // 数组范围在[1,n]
        int slow = 0;
        int fast = numbers[0];
        while (slow != fast) {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        }

        int p = 0;
        int entrance = numbers[fast];
        while (p != entrance) {
            p = numbers[p];
            entrance = numbers[entrance];
        }

        return p;
    }
}
```

