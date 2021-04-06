/*

Leetcode Problem 205: Isomorphic Strings (Easy)

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character
while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

Complexity for this solution:
O(n) time and space
(Note that the number of entries in the map is bounded by the number of characters,
hence the contains() method's complexity can be considered to be constant in this case.)

*/

import java.util.Map;
import java.util.HashMap;

public class IsomorphicStrings {
    
    // Solution using a hash map
    public static boolean isIsomorphic(String s, String t) {
        // Note that the problem guarantees that s and t are of the same length.
        if (s == null || s.length() <= 1) return true;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {
            char c1 = sArr[i];
            char c2 = tArr[i];

            // character of first string has alreay occurred
            if (map.keySet().contains(c1)) {
                // If it has been mapped to another character before, return false.
                // (character mapping has to be unique)
                if (map.get(c1) != c2) return false;
            } else { // character of the first string has not occurred so far
                // If the character of the second string has already occurred, return false.
                // (no two characters may map to the same character)
                if (map.values().contains(c2)) return false;
                // Else, add the characters to the map.
                map.put(c1, c2);
            }
        }

        // all checks successful (mapping is correct)
        return true;

    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }
}