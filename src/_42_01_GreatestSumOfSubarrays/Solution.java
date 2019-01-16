package _42_01_GreatestSumOfSubarrays;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/16
 * @description
 */
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int curNum = 0;
        for (int x : array) {

            if (curNum < 0) {
                curNum = x;
            } else {
                curNum += x;
            }

            max = Math.max(max, curNum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int sum = new Solution().FindGreatestSumOfSubArray(array);
        System.out.println(sum);
    }
}
