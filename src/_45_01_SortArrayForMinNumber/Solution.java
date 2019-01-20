package _45_01_SortArrayForMinNumber;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/20
 * @description
 */
public class Solution {

    public String printMinNumber(int[] nums) {

        StringBuilder res = new StringBuilder();
        if (nums == null || nums.length == 0) {
            return res.toString();
        }

        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Arrays.sort采用的是快排，默认升序
        // 如果str1+str2 > str2+str1，则两者交换
        Arrays.sort(strNums,
                (str1, str2) -> (str1 + str2).compareTo(str2 + str1));

        for (String str : strNums) {
            res.append(str);
        }

        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 32};
        String number = new Solution().printMinNumber(nums);
        System.out.println(number);
    }

}
