/*

Leetcode Problem 387: First Unique Character in a String (Easy)

Given a string, find the first non-repeating character in it and return its index.
If it doesn't exist, return -1.

Complexity for this solution:
O(n) time and space

*/

import java.util.HashMap;

public class FirstUniqueCharacter {
    
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char c = arr[i];
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        for (char c : arr) {
            if (map.get(c) != -1) return map.get(c);
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
