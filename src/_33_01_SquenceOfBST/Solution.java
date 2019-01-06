package _33_01_SquenceOfBST;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/06
 * @description
 */
public class Solution {

    public boolean VerifySquenceOfBST(int[] sequence) {

        // assert sequence is not null or empty
        if (sequence == null || sequence.length < 1) {
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {

        if (start >= end) {
            return true;
        }

        // left is smaller than root
        int left = start;
        while (left <= end) {
            // find the first right val
            if (sequence[left] >= sequence[end]) {
                break;
            }
            left++;
        }

        // right is bigger than root
        int right = left;
        while (right < end) {
            if (sequence[right] < sequence[end]) {
                return false;
            }
            right++;
        }

        return verify(sequence, start, left - 1) && verify(sequence, left, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{5, 7, 6, 9, 11, 10, 8};
        boolean verifySquenceOfBST = new Solution().VerifySquenceOfBST(sequence);
        System.out.println(verifySquenceOfBST);

        sequence = new int[]{7, 4, 6, 5};
        verifySquenceOfBST = new Solution().VerifySquenceOfBST(sequence);
        System.out.println(verifySquenceOfBST);
    }
}
