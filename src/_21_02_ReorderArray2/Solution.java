package _21_02_ReorderArray2;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/29
 */
public class Solution {

    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int oddCount = 0;
        // 统计奇数的个数
        for (int x : array) {
            if ((x & 1) == 1) {
                oddCount++;
            }
        }

        int[] bak = Arrays.copyOf(array, array.length);
        int i = 0, j = oddCount;
        for (int x : bak) {
            if ((x & 1) == 1) {
                array[i++] = x;
            } else {
                array[j++] = x;
            }
        }

    }

    public static void main(String[] args) {
        // 奇数偶数交替
        int[] array = new int[]{2, 1, 5, 3, 7, 6};
        System.out.println("交替前数组为:" + Arrays.toString(array));
        new Solution().reOrderArray(array);
        System.out.println("交替前数组为:" + Arrays.toString(array));

        // 奇数全在前，偶数全在后
        array = new int[]{1, 3, 5, 7, 2, 4, 6};
        System.out.println("交替前数组为:" + Arrays.toString(array));
        new Solution().reOrderArray(array);
        System.out.println("交替前数组为:" + Arrays.toString(array));

        // 偶数全在前，奇数全在后
        array = new int[]{2, 4, 6, 1, 3, 5, 7};
        System.out.println("交替前数组为:" + Arrays.toString(array));
        new Solution().reOrderArray(array);
        System.out.println("交替前数组为:" + Arrays.toString(array));

        // 输入数组内置包含一个数字
        array = new int[]{1};
        System.out.println("交替前数组为:" + Arrays.toString(array));
        new Solution().reOrderArray(array);
        System.out.println("交替前数组为:" + Arrays.toString(array));
    }
}
