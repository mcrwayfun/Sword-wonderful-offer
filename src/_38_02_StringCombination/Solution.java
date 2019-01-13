package _38_02_StringCombination;

import java.util.ArrayList;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/13
 * @description 全组合
 */
public class Solution {

    public ArrayList<String> Combination(String str) {

        ArrayList<String> reList = new ArrayList<>();

        if (str == null || str.length() == 0) {


            return reList;
        }

        char[] chars = str.toCharArray();
        // 字符数组长度
        int length = chars.length;
        // 组合总数2^n = (1 << n)
        int all = 1 << length;

        // a从001开始，000无意义
        for (int i = 1; i < all; i++) {

            StringBuilder res = new StringBuilder();

            // 利用与&的性质，判断1
            // 输出001~111
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    res.append(chars[j]);
                }
            }

            reList.add(res.toString());
        }

        return reList;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abc";
        ArrayList<String> list = solution.Combination(str);
        System.out.println("组合个数为：" + list.size());
        for (String res : list) {
            System.out.println(res);
        }
    }
}
