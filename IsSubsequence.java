/*

Leetcode Problem 392: Is Subsequence (Easy)

Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string
by deleting some (can be none) of the characters without disturbing the relative positions
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Complexity for this solution:
...

*/

public class IsSubsequence {
    
    public static boolean isSubsequence(String s, String t) {
        int i = 0; // start to search for letters in s at this index
        for (char c : s.toCharArray()) {
            // Iterate through the letters of t until we find the current letter.
            while (i < t.length() && c != t.charAt(i)) i++;
            // If we reached the end of the string without finding the letter, return false.
            // If we are not at the end of the string, increment i.
            if (i++ >= t.length()) return false;
        }

        // found all letters
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

}