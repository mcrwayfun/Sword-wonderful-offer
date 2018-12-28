package _20_01_NumericStrings;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/28
 */
public class Solution {

    /**
     * 根据题目要求，输入的应该满足以下格式
     * [sign]integer-digits[.[fragment-digits]][e|E[sign]exponential-digits]
     * []中表示可有可无
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }
        // 分别标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                // e后面要有数字
                if (i == str.length - 1) {
                    return false;
                }
                // 不能同时存在两个e
                if (hasE) {
                    return false;
                }
                // e的前面必须是数字
                if (i > 0 && str[i - 1] < '0' || str[i - 1] > '9') {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第一次出现符号，且不在字符串开头，则必须要跟在e后面
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                // 第二次出现符号，则必须在e后面
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能有小数点，小数点不会出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            }
            // 非法字符
            else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[] str = new char[]{'1', '.', 'e', '1'};
        boolean numeric = new Solution().isNumeric(str);
        System.out.println(numeric);
    }
}
