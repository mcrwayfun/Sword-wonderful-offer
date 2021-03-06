package _14_01_CuttingRope;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 剪绳子求最大乘积
 * @date Created in 2018/12/23
 */
public class Solution {

    public int maxProductAfterCutting(int length) {

        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        // 结果集，数组下标为绳子长
        int[] result = new int[length + 1];

        // 求f(n)可以由以下这4个值构成
        // 比如f(5) = f(2)*f(3)
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        // result数组第i个元素表示把长度为i的切为若干段后乘积的最优解（从4开始算）
        // 因为已经排除了length < 4的情况
        for (int i = 4; i <= length; i++) {
            int max = 0;
            // 当前长度为i，j从1开始，表示剪成i->j-i段
            // 遍历求最大值
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, result[j] * result[i - j]);
            }
            result[i] = max;
        }

        return result[length];
    }

    public static void main(String[] args) {
        int length = 4;
        int productCounting = new Solution().maxProductAfterCutting(length);
        System.out.println("长度为" + length + "绳子的最大乘积为" + productCounting);
    }
}
