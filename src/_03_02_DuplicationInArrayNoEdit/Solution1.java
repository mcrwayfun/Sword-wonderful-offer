package _03_02_DuplicationInArrayNoEdit;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/17
 */
public class Solution1 {

    public int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        // 数组范围在[1,n]
        int slow = 0;
        int fast = numbers[0];
        while (slow != fast) {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        }

        int p = 0;
        int entrance = numbers[fast];
        while (p != entrance) {
            p = numbers[p];
            entrance = numbers[entrance];
        }

        return p;
    }


    public static void main(String[] args) {
        // 长度为 n 的数组中包含一个或多个重复的数字
        int[] numbers = new int[]{1, 3, 5, 4, 3, 2, 6, 7};
        int duplication = new Solution1().getDuplication(numbers);
        System.out.println("数组" + Arrays.toString(numbers) + "包含重复数字：" + duplication);
    }
}
