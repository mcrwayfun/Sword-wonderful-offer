## 二维数组中的查找

### 题目描述

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

### 思路1

二维数组的行数：int rows = array.length

二维数组的列数：int columns = array[0].length

从二维数组的左下方或者右上方开始遍历（不可以从左上方或者右下方，因为无法同时递增递减），打个比方从左下方开始遍历

1. 定义两个指针`i = rows - 1`，`j = 0`，进入循环`i >= 0 && j < columns`
2. 若`array[i][j] == target`，则返回true；若`array[i][j] < target`，则`j++；`否则`i--`

### 方法1

```java
public class Solution {

    public boolean find(int target, int[][] array) {
        if (array == null)
            return false;

        // 行数
        int rows = array.length;
        // 列数
        int columns = array[0].length;

        int i = rows - 1;
        int j = 0;

        while (i >= 0 && j < columns) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                j++;
            } else {// array[i][j] > target
                i--;
            }
        }

        return false;
    }
}
```

- time complexity：O(n^2)