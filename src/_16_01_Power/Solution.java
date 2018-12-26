package _16_01_Power;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/26
 * @description
 */
public class Solution {

    public double power(double base, int exponent) {

        // base为0，返回0
        if (base == 0.0) {
            return base;
        }

        double result = 1.0;
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++) {
            result *= base;
        }

        return exponent > 0 ? result : 1.0 / result;
    }

    public static void main(String[] args) {
        // 指数和底数均为正数
        double base = 2.0;
        int exponent = 3;
        double power = new Solution().power(base, exponent);
        System.out.println("底数为" + base + "的" + exponent + "次方为:" + power);

        // 底数为负数，指数为正数
        base = -2.0;
        exponent = 3;
        power = new Solution().power(base, exponent);
        System.out.println("底数为" + base + "的" + exponent + "次方为:" + power);

        // 底数为正数，指数为负数
        base = 2.0;
        exponent = -3;
        power = new Solution().power(base, exponent);
        System.out.println("底数为" + base + "的" + exponent + "次方为:" + power);

        // 底数为0，指数为负数
        base = 0.0;
        exponent = -3;
        power = new Solution().power(base, exponent);
        System.out.println("底数为" + base + "的" + exponent + "次方为:" + power);

        System.out.println(0.0f/0);
    }

}
