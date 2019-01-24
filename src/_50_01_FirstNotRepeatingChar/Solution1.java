package _50_01_FirstNotRepeatingChar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2019/01/25
 * @description
 */
public class Solution1 {

    public int FirstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }

        Map<Character, Integer> characterMap = new HashMap<>();
        // hashMap is HashTable，search cost O(1)
        for (int i = 0; i < str.length(); i++) {
            characterMap.put(str.charAt(i), characterMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (characterMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String str = "google";
        int index = new Solution1().FirstNotRepeatingChar(str);
        System.out.println(index);
    }
}
