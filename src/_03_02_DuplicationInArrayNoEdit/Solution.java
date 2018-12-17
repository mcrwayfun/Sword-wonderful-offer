package _03_02_DuplicationInArrayNoEdit;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/17
 */
public class Solution {


    public int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        for (int x : numbers)
            if (x < 1 || x > numbers.length - 1)
                return -1;

        // 值范围而不是下标范围
        int left = 1, right = numbers.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            int count = countRange(numbers, left, mid);
            if (left == right) {
                // 存在重复数字
                if (count > 1)
                    return left;

                break;
            } else {
                // 左区间count大于[left,mid]中本应存在的数
                if (count > (mid - left) + 1)
                    right = mid;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 统计数组值在[start,end]中的个数
     *
     * @param numbers 数组
     * @param start   左闭区间
     * @param end     右闭区间
     * @return
     */
    private int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int x : numbers) {
            if (x >= start && x <= end)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // 长度为 n 的数组中包含一个或多个重复的数字
        int[] numbers = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int duplication = new Solution().getDuplication(numbers);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplication);

        // 数组中不包含重复的数字
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7};
        duplication = new Solution().getDuplication(numbers);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplication);

        // 无效测试输入用例（输入空指针)
        duplication = new Solution().getDuplication(null);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplication);
    }
}
