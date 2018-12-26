package _15_02_PowerOf2;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/26
 * @description
 */
public class Solution {

    public boolean powerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 8;
        boolean result = new Solution().powerOf2(n);
        System.out.println(n + "是2的整数次方：" + result);

        n = 9;
        result = new Solution().powerOf2(n);
        System.out.println(n + "是2的整数次方：" + result);
    }
}
