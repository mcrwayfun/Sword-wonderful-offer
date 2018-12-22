## 矩阵中的路径

### 题目描述

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的 3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。


### 思路1

回溯法。首先，任选一个格子作为路径起点。假设格子对应的字符为 ch，并且对应路径上的第 i 个字符。若相等，到相邻格子寻找路径上的第 i+1 个字符。重复这一过程。


### 方法1

```java
public class Solution {

    /**
     * 判断矩阵中是否包含某条路径
     *
     * @param matrix 矩阵
     * @param rows   行
     * @param cols   列
     * @param str    路径数组
     * @return
     */
    public boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 0 ||
                cols < 0 || str == null) {
            return false;
        }

        // 遍历数组，查看是否有符合的路径
        int strLength = 0;
        boolean[][] isVisited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, i, j, str, strLength, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPath(char[][] matrix, int rows, int cols, int i,
                            int j, char[] str, int strLength, boolean[][] isVisited) {

        // 遍历完成，找到了存在的路径
        if (strLength == str.length) {
            return true;
        }

        // 是否包含路径
        boolean hasPath = false;

        // 当前节点matrix[i][j]
        // 是否访问 isVisited[i][j]
        if (i >= 0 && i < rows && j >= 0 && j < cols
                && matrix[i][j] == str[strLength] && !isVisited[i][j]) {

            ++strLength;
            isVisited[i][j] = true;
            // 向该节点的四面进行访问（上下左右）
            hasPath = hasPath(matrix, rows, cols, i - 1, j, str, strLength, isVisited) ||
                    hasPath(matrix, rows, cols, i + 1, j, str, strLength, isVisited) ||
                    hasPath(matrix, rows, cols, i, j - 1, str, strLength, isVisited) ||
                    hasPath(matrix, rows, cols, i, j + 1, str, strLength, isVisited);

            // 当前路径上下左右不包含路径中的元素
            // 则将其标记为未访问且strLength进行减减
            if (!hasPath) {
                --strLength;
                isVisited[i][j] = false;
            }
        }

        return hasPath;
    }
}
```

time complexity:O(n^2)
space complexity:O(1)