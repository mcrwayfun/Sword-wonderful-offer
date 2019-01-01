package _17_Print1ToMaxOfNDigits;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/27
 */
public class Solution {

    int n_count = 0;

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] nums = new char[n];
        Arrays.fill(nums, '0');

        while (!overflow(nums)) {
            printNums(nums);
        }

    }

    private void printNums(char[] nums) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        // 排除0，判断当前需要输出的真正位数
        for (char c : nums) {
            if (c != '0') {
                break;
            }
            count++;
        }

        for (int i = count; i < nums.length; i++) {
            res.append(nums[i]);
        }

        System.out.println(res.toString());
    }

    /**
     * 判断是否有溢出
     *
     * @param nums
     * @return 溢出则返回true，否则返回false
     */
    private boolean overflow(char[] nums) {
        n_count++;
        boolean isOverFlow = false;
        int length = nums.length;
        // 进位1
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i] - '0' + carry;
            // 判断当前位数是否需要进位
            if (num > 9) {
                // 判断是否达到n位数
                if (i == 0) {
                    isOverFlow = true;
                    break;
                }
                // 当前位清0，重新开始进行1-9的循环
                nums[i] = '0';
            } else {
                // 当前位加1，并进行打印
                nums[i]++;
                break;
            }
        }

        return isOverFlow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print1ToMaxOfNDigits(5);

        System.out.println(solution.n_count);
    }
}
