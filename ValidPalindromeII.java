/*

Leetcode Problem 680: Valid Palindrome II (Easy)

Given a non-empty string s, you may delete at most one character.
Judge whether you can make it a palindrome.

Complexity for this solution:
O(n) time and O(1) space

*/

public class ValidPalindromeII {
    
    // Solution 1: using a helper function
    public static boolean validPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // Characters don't match; check whether skipping one of them yields a palindrome.
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }

            // Characters were the same, move the pointers.
            i++;
            j--;
        }

        // all checks done successfully
        return true;
    }

    // helper for solution 2: check whether a substring (from start to end) is a palindrome
    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }


    /*
    Solution 2 (my initial approach):
    Use a boolean to remember whether we have already deleted a character.
    We use the standard two-pointer approach (see No. 125 Valid Palindrome).
    If we encounter non-matching characters, and we haven't deleted yet,
    there are two ways to try to fix the problem:
    Delete the char at the first pointer or the one at the second (i.e., move the respective pointer).
    Check whether moving one of the pointers leads to matching characters.
    If no, return false. If yes set deleted to true and continue.
    */
    public static boolean validPalindrome2(String s) {
        boolean deleted = false;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // characters don't match
            if (s.charAt(i) != s.charAt(j)) {
                // Have we not deleted yet and does deleting the first character help?
                // If yes, do so, set deleted to true and exit the current iteration.
                if (!deleted && s.charAt(i + 1) == s.charAt(j)) {
                    i++;
                    deleted = true;
                    continue;
                // Have we not deleted yet and does deleting the second character help?
                // If yes, do so, set deleted to true and exit the current iteration.
                } else if (!deleted && s.charAt(i) == s.charAt(j - 1)) {
                    j--;
                    deleted = true;
                    continue;
                // We have either already deleted, or deleting doesn't help --> no palindrome.
                } else {
                    return false;
                }
            }

            // Characters were the same, move the pointers.
            i++;
            j--;
        }

        // all checks done successfully
        return true;
    }

    public static void main(String[] args) {
        String s = "cefddfxec"; // is a palindrome if you delete the 'x'
        System.out.println(validPalindrome2(s));
    }
}
