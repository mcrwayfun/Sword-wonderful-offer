package _57_01_TwoNumbersWithSum;

import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/02
 * @description
 */
public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> reList = new ArrayList<>();

        if (array == null || array.length == 0 || sum <= array[0]) {
            return reList;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {

            int curSum = array[start] + array[end];
            if (curSum == sum) {
                reList.add(array[start]);
                reList.add(array[end]);
                return reList;
            } else if (curSum < sum) {
                start++;
            } else {
                end--;
            }
        }

        // 查无
        return reList;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 11, 15};
        ArrayList<Integer> integers = new Solution().FindNumbersWithSum(array, 15);
        for (int x : integers) {
            System.out.println(x);
        }
    }
}
