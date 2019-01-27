package _53_02_MissingNumber;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/27
 * @description
 */
public class Solution1 {

    public int getMissingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int xor = 0, i = 0;
        for (; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 2, 4};
        int missingNumber = new Solution1().getMissingNumber(nums);
        System.out.println(missingNumber);
    }

}
