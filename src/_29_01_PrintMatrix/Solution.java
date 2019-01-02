package _29_01_PrintMatrix;

import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/2
 */
public class Solution {

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> reList = new ArrayList<>();
        if (matrix == null) {
            return reList;
        }

        int start = 0;
        int rows = matrix.length;
        int colums = matrix[0].length;

        while (rows > start * 2 && colums > start * 2) {
            printMatrix(matrix, rows, colums, start, reList);
            start++;
        }

        return reList;
    }

    private void printMatrix(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> reList) {

        // 相当于坐标轴中的y坐标
        int endX = columns - start - 1;
        // 相当于坐标轴中的x坐标
        int endY = rows - start - 1;

        // 从左到右，x增加y不变
        for (int i = start; i <= endX; i++) {
            reList.add(matrix[start][i]);
        }

        // 从上到下，[]
        for (int i = start + 1; i >= start; i--) {
            reList.add(matrix[i][endX]);
        }

        // 从右到左，[unchanging,reduce]
        for (int i = endX - 1; i >= start; i--) {
            reList.add(matrix[endY][i]);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> integers = new Solution().printMatrix(matrix);
        for (int x : integers) {
            System.out.println(x);
        }
    }
}
