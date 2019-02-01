package _57_01_TwoNumbersWithSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/02
 * @description
 */
public class Solution2 {

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

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            int sub = sum - array[i];
            // 从左到右找到的第一对sum，乘积肯定是最小的
            if (map.containsKey(sub)) {
                reList.add(array[i]);
                reList.add(sub);
                break;
            }
        }

        return reList;
    }
}
