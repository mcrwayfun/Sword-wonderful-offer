## 礼物的最大价值

### 题目描述

在一个 `m×n` 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。

你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。

给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？

### 思路

根据题目的要求，我们有两种途径可以到达坐标为(i,j)的格子，即(i-1,j)或者(i,j-1)。

所以有f(i,j)=max( (i-1,j) , (i,j-1) ) + gift(i,j) ，gift(i,j)表示(i,j)格子礼物的价值。

### 方法

```java
public class Solution {

    public int getMaxValue(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int[][] maxValues = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = maxValues[i - 1][j];
                if (j > 0)
                    left = maxValues[i][j - 1];

                maxValues[i][j] = Math.max(up, left) + grid[i][j];
            }
        }

        return maxValues[rows - 1][columns - 1];
    }
}
```

- time complexity:O(n^m)
- space complexity:O(n^m)
