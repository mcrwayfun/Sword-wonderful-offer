package _15_01_NumberOf1InBinary;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 二进制中 1 的个数
 * @date Created in 2018/12/25
 */
public class Solution {

    public int NumberOf1(int n) {
        int cnt = 0;
        int i = 1;
        while (i != 0) {
            if ((n & i) != 0) {
                ++cnt;
            }
            // i左移32位后为0
            i <<= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int numberOf1 = new Solution().NumberOf1(9);
        System.out.println(numberOf1);
    }
}
