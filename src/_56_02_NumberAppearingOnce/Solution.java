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
            return 0;
        }

        int[] bits = new int[32];
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int val = nums[i];
            for (int j = 0; j < 32; ++j) {
                bits[j] += (val & 1);
                val = val >> 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if (bits[i] % 3 != 0) {
                res += Math.pow(2, i);
            }
        }

        return res;
    }
}
