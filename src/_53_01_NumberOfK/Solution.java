package _53_01_NumberOfK;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/27
 * @description
 */
public class Solution {

    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int startK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);

        int number = 0;
        if (lastK > -1 && startK > -1) {
            number = lastK - startK + 1;
        }

        return number;
    }

    /**
     * 获取数组中第一个k的下标
     *
     * @param array 数组
     * @param k     k
     * @param start
     * @param end
     * @return 下标（不存在则返回-1）
     */
    private int getFirstK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        int data = array[middle];
        // 中间刚好是k
        if (data == k) {
            // 判断前面是否存在k
            if (middle > 0 && array[middle - 1] == k) {
                end = middle - 1;
            } else {
                return middle;
            }
        } else if (data > k) {
            // 第一个k在前半部分
            end = middle - 1;
        } else {
            start = middle + 1;
        }

        return getFirstK(array, k, start, end);
    }

    /**
     * 获取数组中最后一个k
     *
     * @param array 数组
     * @param k     k
     * @param start
     * @param end
     * @return 下标（不存在则返回-1）
     */
    private int getLastK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;
        int data = array[middle];

        if (data == k) {
            // 判断后面还有没有k
            if (middle < array.length - 1 && array[middle + 1] == k) {
                start = middle + 1;
            } else {
                return middle;
            }
        } else if (data > k) {
            // 最后一个k在前半部分
            end = middle - 1;
        } else {
            start = middle + 1;
        }

        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,1,2,3,4,5};
        int number = new Solution().GetNumberOfK(array, 6);
        System.out.println(number);
    }
}
