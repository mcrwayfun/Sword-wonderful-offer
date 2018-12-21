package _10_01_Fibonacci;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/21
 */
public class Solution {

    public int Fibonacci(int n) {
        // n = 0, fn = 0
        // n = 1, fn = 1
        // n > 1, fn = f(n-1) + f(n - 2);
        if (n < 2)
            return n;

        int numberOne = 0;
        int numberTwo = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = numberOne + numberTwo;
            numberOne = numberTwo;
            numberTwo = result;
        }

        return result;
    }

    public static void main(String[] args) {
        // 输入1
        int n = 1;
        int fibonacci = new Solution().Fibonacci(n);
        System.out.println("输入" + n + "，输出结果为:" + fibonacci);

        // 输入3
        n = 3;
        fibonacci = new Solution().Fibonacci(n);
        System.out.println("输入" + n + "，输出结果为:" + fibonacci);
    }
}
