package _03_01_DuplicationInArray;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/16
 * @description
 */
public class Solution {

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 1)
            return false;

        for (int x : numbers)
            if (x < 0 || x >= length)
                return false;

        for (int i = 0; i < length; i++) {
            // 当前下标不等于当前值
            while (i != numbers[i]) {

                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                // 交换
                swap(numbers, numbers[i], i);
            }
        }

        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // 长度为 n 的数组中包含一个或多个重复的数字
        int[] numbers = new int[]{2, 3, 1, 0, 2, 5, 3};
        boolean duplicate = new Solution().duplicate(numbers, numbers.length, new int[1]);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplicate);

        // 数组中不包含重复的数字
        numbers = new int[]{0, 1, 2, 3, 4};
        duplicate = new Solution().duplicate(numbers, numbers.length, new int[1]);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplicate);

        // 无效测试输入用例（输入空指针；长度为 n 的数组中包含 0~n-1 之外的数字）
        numbers = new int[]{5, 1, 2};
        duplicate = new Solution().duplicate(numbers, numbers.length, new int[1]);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplicate);

    }
}
