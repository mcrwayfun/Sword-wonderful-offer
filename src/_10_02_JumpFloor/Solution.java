package _10_02_JumpFloor;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description 跳青蛙
 * @date Created in 2018/12/21
 */
public class Solution {

    public int JumpFloor(int target) {
        // n = 1,fn = 1
        // n = 2,fn = 2（每次跳一级台阶，或者一次跳二级台阶）
        // n > 2,fn = f(n-1)+f(n-2)
        if (target < 3)
            return target;

        int numberOne = 1;
        int numberTwo = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = numberOne + numberTwo;
            numberOne = numberTwo;
            numberTwo = result;
        }

        return result;
    }

}
