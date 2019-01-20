package _46_01_TranslateNumbersToStrings;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/20
 * @description
 */
public class Solution {

    public int getTranslationCount(String s) {

        if (s == null || s.length() < 2) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];

        res[0] = 1;
        res[1] = isInRange(chars[0], chars[1]) ? 2 : 1;
        for (int i = 2; i < chars.length; i++) {
            res[i] = res[i - 1] + (isInRange(chars[i - 1], chars[i]) ? res[i - 2] : 0);
        }

        return res[chars.length - 1];
    }

    /**
     * 判断是否处于[10,25]之间
     *
     * @param a
     * @param b
     * @return
     */
    private boolean isInRange(char a, char b) {
        int num = (a - '0') * 10 + (b - '0');
        return num >= 10 && num <= 25;
    }

    public static void main(String[] args) {
        int translationCount = new Solution().getTranslationCount("12258");
        System.out.println(translationCount);
    }
}
