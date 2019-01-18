package _44_01_DigitsInSequence;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/18
 * @description
 */
public class Solution {

    public int digitAtIndex(int n) {
        if (n < 0) {
            return -1;
        }

        int digits = 1;
        while (true) {
            // 根据位数判断当前是前几位
            // 比如1则是前10位，因为有0~9这10个数字，所以1*10=10
            // 比如2则是前180位，因为有10~99这90个数字，所以2*90=180
            long numbers = countOfIntegers(digits);

            // n是否在当前位数中
            if (n < digits * numbers) {
                break;
            }

            // 不在则n减去相应的位数
            n -= numbers * digits;
            digits++;
        }


        return digitAtIndex(digits, n);
    }

    private long countOfIntegers(int digits) {
        return digits == 1 ? 10 : (int) (9 * Math.pow(10, digits - 1));
    }

    private int digitAtIndex(int digits, int n) {
        // 获取m位数的第一个数字
        // 比如1位第一个数字是0，2位第一个数字是10
        int beginNumber = getBeginNumber(digits);
        // 获取这是哪个数，比如求第1001对应的数字，则此时n=811，digits=3,n/digits=270
        // val = 100+270=370，即第1001对应的那个数是370
        int val = beginNumber + n / digits;
        // 第1001位处于370的哪一位
        int indexFromRight = digits - n % digits;
        // 求出位数
        for (int i = 1; i < indexFromRight; ++i) {
            val /= 10;
        }
        return val % 10;
    }

    private int getBeginNumber(int digits) {
        return digits == 1 ? 0 : (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        new Solution().digitAtIndex(1001);
    }
}
