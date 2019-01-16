package _42_01_GreatestSumOfSubarrays;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/16
 * @description
 */
public class Solution1 {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int[] res = new int[array.length];
        int max = res[0];
        for (int i = 1; i < array.length; i++) {
            res[i] = res[i - 1] > 0 ? res[i - 1] + array[i] : array[i];
            max = Math.max(max, res[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int sum = new Solution1().FindGreatestSumOfSubArray(array);
        System.out.println(sum);
    }
}
