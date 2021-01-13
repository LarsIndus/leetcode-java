/*

Leetcode Problem 242: Valid Anagram (Easy)

Given two strings s and t , write a function to determine if t is an anagram of s.

Complexity for this solution:
O(max(n, m)) time (where n, m are the lenghts of the strings) and O(1) space (only 26 characters!).

*/

public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            // if there is a character in t that was not in s, return false already
            if (counts[c - 'a'] == 0) return false;
            counts[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t ="nagaram";
        System.out.println(isAnagram(s, t));
    }
}
