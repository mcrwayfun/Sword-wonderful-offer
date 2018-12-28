package _20_01_NumericStrings;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/29
 * @description
 */
public class Solution1 {

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }

    public static void main(String[] args) {
        char[] str = new char[]{'.', 'e', '1'};
        boolean numeric = new Solution1().isNumeric(str);
        System.out.println(numeric);
    }
}
