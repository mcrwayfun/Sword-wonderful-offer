package _48_01_LongestSubstringWithoutDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/22
 */
public class Solution {

    public int longestSubstringWithoutDuplication(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        // 字符出现的位置
        int[] characters = new int[26];
        // 使用-1填充
        Arrays.fill(characters, -1);
        // 计算结果
        int[] res = new int[chars.length];

        // 初始化第一个字符出现次数为1
        res[0] = 1;
        // 最长字符出现次数
        int maxLength = res[0];
        // chars数组中第一个字符出现的位置，从下标0开始计算
        characters[chars[0] - 'a'] = 0;

        for (int i = 1; i < chars.length; i++) {

            // 获取字符出现的下标
            int index = characters[chars[i] - 'a'];
            // 计算两个相同字符出现距离
            int distance = i - index;

            res[i] = (index == -1 || distance > res[i - 1]) ?
                    res[i - 1] + 1 : distance;

            maxLength = Math.max(maxLength, res[i]);
            characters[chars[i] - 'a'] = i;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "arabcacfr";
        Solution solution = new Solution();
        int max = solution.longestSubstringWithoutDuplication(s);
        System.out.println(max);
    }
}
