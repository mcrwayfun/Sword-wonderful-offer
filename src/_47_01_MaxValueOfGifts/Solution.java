package _47_01_MaxValueOfGifts;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/21
 * @description
 */
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

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };

        int maxValue = new Solution().getMaxValue(grid);
        System.out.println(maxValue);
    }
}
