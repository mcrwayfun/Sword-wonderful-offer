package _12_01_StringPathInMatrix;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 判断矩阵中是否包含某条路径
 * @date Created in 2018/12/22
 */

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

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'a', 'f', 'c', 'd'},
                {'g', 'h', 'a', 't'},
                {'y', 't', 'f', 'p'}
        };

        char[] str = new char[]{'f', 'c', 'a', 't'};
        boolean hasPath = new Solution().hasPath(matrix, matrix.length, matrix[0].length, str);
        System.out.println(hasPath);
    }
}
