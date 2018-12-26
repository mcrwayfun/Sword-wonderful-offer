package _15_01_NumberOf1InBinary;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/26
 * @description
 */
public class Solution1 {

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int numberOf1 = new Solution1().NumberOf1(9);
        System.out.println(numberOf1);
    }
}
