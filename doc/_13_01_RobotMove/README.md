## 机器人的移动范围

### 题目描述

地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？


### 思路1

回溯法。


### 方法1

```java
public class Solution {
     /**
      * 机器人移动的范围
      *
      * @param threshold 目标数
      * @param rows      行数
      * @param cols      列数
      * @return
      */
     public int movingCount(int threshold, int rows, int cols) {
         // 移动范围不存在
         if (threshold < 0 || rows <= 0 || cols <= 0) {
             return 0;
         }
 
         boolean[][] isVisited = new boolean[rows][cols];
 
         return getCount(threshold, 0, 0, rows, cols, isVisited);
     }
 
 
     private int getCount(int threshold, int i, int j, int rows, int cols, boolean[][] isVisited) {
         if (i >= 0 && i < rows && j >= 0 && j < cols
                 && !isVisited[i][j] && (getSumOfDig(i) + getSumOfDig(j)) <= threshold) {
             isVisited[i][j] = true;
             return 1 + getCount(threshold, i - 1, j, rows, cols, isVisited)
                     + getCount(threshold, i + 1, j, rows, cols, isVisited)
                     + getCount(threshold, i, j - 1, rows, cols, isVisited)
                     + getCount(threshold, i, j + 1, rows, cols, isVisited);
         } else {
             return 0;
         }
     }
 
     /**
      * 求num的个位数之和
      *
      * @param num
      * @return
      */
     private int getSumOfDig(int num) {
         int res = 0;
 
         // 循环求num的个位数
         while (num > 0) {
             res += num % 10;
             num = num / 10;
         }
         return res;
     }  
}
```

time complexity:O(n^2)
space complexity:O(1)