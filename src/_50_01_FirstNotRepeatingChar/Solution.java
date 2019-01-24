package _50_01_FirstNotRepeatingChar;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/24
 * @description
 */
public class Solution {

    public int FirstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }

        char[] charArray = str.toCharArray();

        int[] result = new int['z' + 1];
        for (char c : charArray) {
            result[(int) c]++;
        }

        for (int i = 0; i < charArray.length; i++) {
            // 找到第一个为1的字符
            if (result[(int) charArray[i]] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "google";
        int index = new Solution().FirstNotRepeatingChar(str);
        System.out.println(index);
    }
}
