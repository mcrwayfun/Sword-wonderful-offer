package _39_01_MoreThanHalfNumber;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/13
 * @description
 */
public class Solution {

    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        // 记录某个数出现的次数
        int times = 1;
        int num = array[0];

        for (int i = 0; i < array.length; i++) {

            // 如果times为0，则num记录为新值，并把times设置为1
            if (times == 0) {
                num = array[i];
                times = 1;
            }
            // 如果当前值与上一个值（num）相等，则times++
            else if (num == array[i]) {
                times++;
            }
            // 否则times--
            else {
                times--;
            }
        }

        // 最后留下的num是出现次数最多的值
        // 判断num是否出现次数超过一半
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }

        return count > array.length / 2 ? num : 0;
    }

}
