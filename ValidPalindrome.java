/*

Leetcode Problem 125: Valid Palindrome (Easy)

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Complexity for this solution:
O(n) time and O(1) space (first solution; second uses O(n) space)

*/

public class ValidPalindrome {

    // Solution 1: Use two pointers (one from the head, one from the tail)
    public static boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        char charHead, charTail;
        while (i < j) {
            // Note that in all condition checking inside this loop, we have to add i < j again!
            charHead = s.charAt(i);
            charTail = s.charAt(j);

            // If characters are not alphanumeric, move the pointers.
            while (i < j && !Character.isLetterOrDigit(charHead)) {
                i++;
            }
            while (!Character.isLetterOrDigit(charTail)) {
                j--;
            }

            // If they are alphanumberic but not equal, return false.
            if (i < j && Character.toLowerCase(charHead) != Character.toLowerCase(charTail)) {
                return false;
            }

            // Characters were the same, move the pointers.
            i++;
            j--;
        }

        // all checks done successfully
        return true;
    }

    // Solution 2: Regex + two pointers (shorter code, but uses O(n) additional space)
    public static boolean isPalindrome2(String s) {
        // remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome1(s));
    }
}