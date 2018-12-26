package _15_03_ChangeBinaryNumber;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/26
 * @description
 */
public class Solution {

    public int changeNum(int m, int n) {
        // 进行异或（不同为1）
        int value = m ^ n;
        int count = 0;
        while (value != 0) {
            count++;
            value = value & (value - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // 1010
        int m = 10;
        // 1101
        int n = 13;
        int changeNum = new Solution().changeNum(m, n);
        System.out.println(m + "需要改变" + changeNum + "位可以转变为" + n);
    }
}
