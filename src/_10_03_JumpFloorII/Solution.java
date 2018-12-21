package _10_03_JumpFloorII;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/21
 */
public class Solution {

    public int JumpFloorII(int target) {
        // fn = 2^(n-1)
        return (int) Math.pow(2, target - 1);
    }
}
