package _53_02_MissingNumber;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/27
 * @description
 */
public class Solution {

    public int getMissingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int data = nums[mid];
            if (data != mid) {
                // 前一个数字是相等的，则data是第一个不相等的数字
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    // 不相等的在前半部分
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        // 前面数字都相等，说明缺失的是最大的数字
        if (left == nums.length) {
            return nums.length;
        }

        // 无效输入
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 5};
        int missingNumber = new Solution().getMissingNumber(nums);
        System.out.println(missingNumber);
    }
}
