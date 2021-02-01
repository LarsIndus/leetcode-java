/*

Leetcode Problem 5: Largest Palindromic Substring (Medium)

Given a string s, return the longest palindromic substring in s.

Complexity for this solution:
O(n^2) time and O(1) space (use three pointers, see below)

*/

public class LargestPalindromicSubstring {
    
    private static String largestPalindromeAtIndex(String s, int left, int right) {
        int leftIndex = 0;
        int rightIndex = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                leftIndex = left;
                rightIndex = right;
            } else {
                break;
            }
            left--;
            right++;
        }

        return s.substring(leftIndex, rightIndex + 1);
    }

    private static String longestPalindrome(String s) {
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            String palindromeodd = largestPalindromeAtIndex(s, i, i);
            String palindromeeven = largestPalindromeAtIndex(s, i, i + 1);
            String largerPalindrome = (palindromeodd.length() > palindromeeven.length()) ? palindromeodd : palindromeeven;
            
            result = (result.length() > largerPalindrome.length()) ? result : largerPalindrome;
        }

        return result;
    }

    public static void main(String[] args) {
        String testStr = "babad";
        System.out.println(LargestPalindromicSubstring.longestPalindrome(testStr));
    }
}
