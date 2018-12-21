package _11_01_MinNumberInRotatedArray;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 旋转数组的最小元素
 * @date Created in 2018/12/21
 */
public class Solution {

    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        int length = array.length;

        // 仅有1个元素
        if (length == 1) {
            return array[0];
        }

        // 旋转0个元素，已经是排好序的数组
        if (array[0] < array[length - 1])
            return array[0];

        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            // 当left和right相邻时，那么right指向的元素就是最小元素
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = left + (right - left) / 2;
            // 当left，right和mid指向的数值相同时，只能顺序查找最小值
            // 比如有[0,1,1,1,1] -> [1,0,1,1,1]
            if (array[left] == array[right]
                    && array[mid] == array[left]) {
                mid = getMinIndex(array);
                break;
            }


            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return array[mid];
    }

    private int getMinIndex(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = array[i] < array[minIndex] ? i : minIndex;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        // 升序排序数组的一个旋转
        int[] array = new int[]{4, 5, 1, 2, 3};
        int min = new Solution().minNumberInRotateArray(array);
        System.out.println("旋转数组" + Arrays.toString(array) + "的最小值为：" + min);

        // 数组中有重复数字
        array = new int[]{1, 0, 1, 1, 1};
        min = new Solution().minNumberInRotateArray(array);
        System.out.println("旋转数组" + Arrays.toString(array) + "的最小值为：" + min);

        array = new int[]{1, 1, 0, 1, 1};
        min = new Solution().minNumberInRotateArray(array);
        System.out.println("旋转数组" + Arrays.toString(array) + "的最小值为：" + min);

        // 升序数组
        array = new int[]{1, 2, 3, 4, 5};
        min = new Solution().minNumberInRotateArray(array);
        System.out.println("旋转数组" + Arrays.toString(array) + "的最小值为：" + min);

        // 只包含一个数字的数组
        array = new int[]{3};
        min = new Solution().minNumberInRotateArray(array);
        System.out.println("旋转数组" + Arrays.toString(array) + "的最小值为：" + min);
    }
}
