package _56_02_NumberAppearingOnce;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/01
 * @description
 */
public class Solution {

    public int findNumberAppearingOnce(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        // 存储每个数对应的位数和
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            for (int j = 0; j < 32; j++) {
                // 获取value每一位数，并求和
                bitSum[j] += value & 1;
                value = value >> 1;
            }
        }

        int retValue = 0;
        for (int i = 0; i < 32; i++) {
            // 如果不能被3整除，说明当出现一次的数字的对应位数为1
            if (bitSum[i] % 3 != 0) {
                retValue += Math.pow(2, i);
            }
        }

        return retValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 3, 3};
        int numberAppearingOnce = new Solution().findNumberAppearingOnce(nums);
        System.out.println(numberAppearingOnce);
    }
}
