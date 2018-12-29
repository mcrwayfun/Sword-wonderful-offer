package _21_01_ReorderArray;

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

        int odd = 0, even = array.length - 1;
        while (odd < even) {

            // odd向后移动，直到遇见奇数
            while (odd < even && (array[odd] & 1) != 0) {
                odd++;
            }

            // even向前移动，直到遇到偶数
            while (odd < even && (array[even] & 1) != 1) {
                even--;
            }

            swap(array, odd, even);
        }
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
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
