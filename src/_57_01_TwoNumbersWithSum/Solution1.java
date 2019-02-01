package _57_01_TwoNumbersWithSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/02
 * @description
 */
public class Solution1 {

    /**
     * 如果输入的数组是乱序的
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> reList = new ArrayList<>();

        if (array == null || array.length < 2 || sum <= array[0]) {
            return reList;
        }

        Set<Integer> set = new HashSet<>();
        for (int x : array) {

            if (set.contains(sum - x)) {
                reList.add(sum - x);
                reList.add(x);
                return reList;
            }

            set.add(x);
        }

        return reList;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 11, 15};
        ArrayList<Integer> integers = new Solution1().FindNumbersWithSum(array, 15);
        for (int x : integers) {
            System.out.println(x);
        }
    }

}
