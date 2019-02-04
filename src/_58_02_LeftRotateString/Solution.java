package _58_02_LeftRotateString;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/04
 * @description
 */
public class Solution {

    public String LeftRotateString(String str, int n) {

        if (str == null || str.length() == 0
                || str.trim().equals("") || n < 1) {

            return str;
        }

        char[] chars = str.toCharArray();
        // 翻转前面n部分
        reverse(chars, 0, n - 1);
        // 翻转剩余的部分
        reverse(chars, n, chars.length - 1);
        // 整体翻转
        reverse(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {

        if (chars == null || chars.length == 0) {
            return;
        }

        while (start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        String leftRotateString = new Solution().LeftRotateString(str, 2);
        System.out.println(leftRotateString);
    }
}
