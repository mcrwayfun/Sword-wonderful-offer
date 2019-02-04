package _58_01_ReverseWordsInSentence;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/04
 * @description
 */
public class Solution {

    public String ReverseSentence(String str) {

        if (str == null || str.length() == 0) {
            return "";
        }

        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        // 翻转整个字符串
        reverse(chars, start, end);

        // 翻转单个字符
        start = 0;
        end = 0;
        while (end < chars.length) {

            if (chars[start] == ' ') {
                start++;
                end++;
            } else if (chars[end] == ' ') {
                reverse(chars, start, --end);
                // 下一个翻转单词起始
                start = ++end;
            } else {
                end++;
            }
        }

        reverse(chars, start, chars.length - 1);
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
        String str = "I am a student.";
//        str = "Wonderful";
        Solution solution = new Solution();

        String reverseSentence = solution.ReverseSentence(str);
        System.out.println(reverseSentence);
    }
}
