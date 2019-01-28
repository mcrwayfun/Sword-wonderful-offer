package _53_03_IntegerIdenticalToIndex;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/28
 */
public class Solution {

    public int getNumberSameAsIndex(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int data = nums[mid];

            if (mid == data) {
                return data;
            } else if (mid > data) {
                // 下标大于元素值，则去右边找
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, -1, 1, 3, 5};
        int numberSameAsIndex = new Solution().getNumberSameAsIndex(nums);
        System.out.println(numberSameAsIndex);
    }
}
