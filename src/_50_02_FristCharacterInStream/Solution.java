package _50_02_FristCharacterInStream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/25
 */
public class Solution {

    private StringBuilder res = new StringBuilder();
    private Map<Character, Integer> characterMap = new HashMap<>();

    // Insert one char from stringstream
    public void Insert(char ch) {
        res.append(ch);
        characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        for (char c : res.toString().toCharArray()) {
            if (characterMap.get(c) == 1) {
                return c;
            }
        }

        return '#';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert('g');
        solution.Insert('o');
        solution.Insert('o');
        solution.Insert('g');
        solution.Insert('l');
        solution.Insert('e');

        char firstAppearingOnce = solution.FirstAppearingOnce();
        System.out.println(firstAppearingOnce);
    }
}
