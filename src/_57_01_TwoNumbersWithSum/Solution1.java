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
                // 保持顺序
                if (x < sum - x) {
                    reList.add(x);
                    reList.add(sum - x);
                } else {
                    reList.add(sum - x);
                    reList.add(x);
                }
            }

            set.add(x);
        }

        if (!reList.isEmpty()) {
            // 最小乘积对应的下标
            int smallIndex = 0;
            // 最小乘积
            int count = sum * sum;
            for (int i = 0; i < reList.size() && i + 1 < reList.size(); i = i + 2) {
                int curCount = reList.get(i) * reList.get(i + 1);
                if (curCount < count) {
                    count = curCount;
                    smallIndex = i;
                }
            }

            // 设置输出列表前两个元素为乘积最小的元素
            if (count != sum * sum && smallIndex + 1 < reList.size()) {
                int smallOne = reList.get(smallIndex);
                int smallOne2 = reList.get(smallIndex + 1);
                reList = new ArrayList<>();
                reList.add(smallOne);
                reList.add(smallOne2);
                return reList;
            }
        }

        return reList;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> integers = new Solution1().FindNumbersWithSum(array, 21);
        for (int x : integers) {
            System.out.println(x);
        }
    }

}
