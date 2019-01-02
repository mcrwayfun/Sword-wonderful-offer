package _29_01_PrintMatrix;

import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/02
 * @description
 */
public class Solution1 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> reList = new ArrayList<>();
        if (matrix == null) {
            return reList;
        }

        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tR <= dR && tC <= dC) {
            printMatrix(matrix, tR++, tC++, dR--, dC--, reList);
        }

        return reList;
    }

    public void printMatrix(int[][] matrix, int tR, int tC, int dR, int dC, ArrayList<Integer> reList) {
        // 只有一行
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                reList.add(matrix[tR][i]);
            }
        }
        // 只有一列
        else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                reList.add(matrix[i][tC]);
            }
        } else {
            int curR = tR;
            int curC = tC;
            // 从左到右
            while (curC != dC) {
                reList.add(matrix[tR][curC]);
                curC++;
            }
            // 从上到下
            while (curR != dR) {
                reList.add(matrix[curR][dC]);
                curR++;
            }
            // 从右到左
            while (curC != tC) {
                reList.add(matrix[dR][curC]);
                curC--;
            }
            // 从下到上
            while (curR != tR) {
                reList.add(matrix[curR][tC]);
                curR--;
            }
        }

    }


}
