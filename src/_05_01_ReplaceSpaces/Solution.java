package _05_01_ReplaceSpaces;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/18
 */
public class Solution {

    public String replaceSpace(String str) {
        if (str == null || str.length() == 0)
            return null;

        StringBuilder stringBuilder = new StringBuilder(str);
        // 遍历str，遇到空格则新增两个空字符
        int len = stringBuilder.length();
        for (int i = 0; i < len; i++) {
            if (stringBuilder.charAt(i) == ' ')
                stringBuilder.append("  ");
        }

        // 定义两个指针
        // p指针指向原字符串末尾
        int p = len - 1;
        // q指针指向现有指针末尾
        int q = stringBuilder.length() - 1;

        while (p != q) {
            char ch = stringBuilder.charAt(p--);
            if (ch == ' ') {
                stringBuilder.setCharAt(q--, '0');
                stringBuilder.setCharAt(q--, '2');
                stringBuilder.setCharAt(q--, '%');
            } else {
                stringBuilder.setCharAt(q--, ch);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // 输入的字符串包含空格
        String str = "We are happy";
        String replaceSpace = new Solution().replaceSpace(str);
        System.out.println("字符串[" + str + "]替换为[" + replaceSpace + "]");

        // 输入的字符串中没有空格
        str = "Wearehappy";
        replaceSpace = new Solution().replaceSpace(str);
        System.out.println("字符串[" + str + "]替换为[" + replaceSpace + "]");

        // 特殊输入测试（字符串是一个空指针；字符串是一个空字符串；字符串只有一个空格字符；字符串中有多个连续空格）
        str = null;
        replaceSpace = new Solution().replaceSpace(str);
        System.out.println("字符串[" + str + "]替换为[" + replaceSpace + "]");

        // 字符串是一个空字符串
        str = "";
        replaceSpace = new Solution().replaceSpace(str);
        System.out.println("字符串[" + str + "]替换为[" + replaceSpace + "]");

        // 字符串只有一个空格字符
        str = " ";
        replaceSpace = new Solution().replaceSpace(str);
        System.out.println("字符串[" + str + "]替换为[" + replaceSpace + "]");

        // 字符串中有多个连续空格
        str = "  a";
        replaceSpace = new Solution().replaceSpace(str);
        System.out.println("字符串[" + str + "]替换为[" + replaceSpace + "]");
    }
}
