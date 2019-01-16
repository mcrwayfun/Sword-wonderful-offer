package _43_01_NumberOf1;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/17
 * @description
 */
public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {

        if (n < 1) {
            return 0;
        }

        int number = 0;

        for (int i = 1; i <= n; i++) {
            number += getNumber(i);
        }

        return number;
    }

    private int getNumber(int n) {

        int number = 0;

        while (n != 0) {

            if (n % 10 == 1) {
                number++;
            }

            n = n / 10;
        }

        return number;
    }

    public static void main(String[] args) {
        int number = new Solution().NumberOf1Between1AndN_Solution(13);
        System.out.println(number);
    }
}
