package _04_01_FindInPartiallySortedMatrix;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/17
 */
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

    public static void main(String[] args) {
        // 二维数组中包含查找的数字（查找的数字是数组中的最大值和最小值）
        int[][] numbers = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // 最小
        int target = 1;
        boolean hasFind = new Solution().find(target, numbers);
        System.out.println("数组是否包含数字" + target + ":" + hasFind);

        // 最大
        target = 12;
        hasFind = new Solution().find(target, numbers);
        System.out.println("数组是否包含数字" + target + ":" + hasFind);

        // 二维数组中包含查找的数字（查找的数字介于数组中的最大值和最小值之间）
        // 介于最大最小之间
        target = 6;
        hasFind = new Solution().find(target, numbers);
        System.out.println("数组是否包含数字" + target + ":" + hasFind);

        // 二维数组中没有查找的数字
        target = 13;
        hasFind = new Solution().find(target, numbers);
        System.out.println("数组是否包含数字" + target + ":" + hasFind);

        // 特殊输入测试（输入空指针）
        hasFind = new Solution().find(target, null);
        System.out.println("数组是否包含数字" + target + ":" + hasFind);
    }
}
