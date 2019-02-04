package _58_01_ReverseWordsInSentence;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/02/04
 * @description
 */
public class Solution1 {

    public String ReverseSentence(String str) {

        // 当输入的str全是空格时，同样也要排除这种情况
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return str;
        }

        String[] splitArray = str.split(" ");
        reverse(splitArray, 0, splitArray.length - 1);

        return String.join(" ", splitArray);
    }

    private void reverse(String[] array, int start, int end) {

        if (array == null || array.length == 0) {
            return;
        }

        while (start <= end) {
            String temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        str = "Wonderful";
        str = "    ";
        Solution1 solution = new Solution1();

        String reverseSentence = solution.ReverseSentence(str);
        System.out.println(reverseSentence);
    }
}
