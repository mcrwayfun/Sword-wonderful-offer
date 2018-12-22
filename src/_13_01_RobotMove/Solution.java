package _13_01_RobotMove;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 机器人的移动范围
 * @date Created in 2018/12/22
 */
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

    public static void main(String[] args) {
        int threshold = 3;
        int count = new Solution().movingCount(threshold, 1, 1);
        System.out.println(count);
    }
}
