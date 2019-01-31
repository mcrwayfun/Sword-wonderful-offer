package _56_01_NumbersAppearOnce;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/31
 * @description
 */
public class Solution {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        // 数组进行异或操作，找到两个不同数的异或结果
        int xor = 0;
        for (int x : array) {
            xor = xor ^ x;
        }

        // 找出结果数中第一个为1的位置（从左向右）
        int index = findFirst1(xor);
        // 将数组分为两个部分，其中index位为1的为一组，index为0的为一组
        for (int x : array) {
            if (isBit1(x, index)) {
                num1[0] = num1[0] ^ x;
            } else {
                num2[0] = num2[0] ^ x;
            }
        }
    }

    /**
     * 找出结果数中第一个为1的位置（从左向右）
     *
     * @param xor
     * @return
     */
    private int findFirst1(int xor) {

        int index = 0;

        while ((xor & 1) == 0) {
            xor = xor >> 1;
            index++;
        }

        return index;
    }

    private boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution.FindNumsAppearOnce(array, num1, num2);

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
