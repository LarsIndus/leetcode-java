/*

Leetcode Problem 9: Palindrome Number (Easy)

Determine whether an integer is a palindrome.
An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

Complexity for this solution:
...

*/

public class PalindromeNumber {
    
    // Solution 1: Convert to string
    public static boolean isPalindrome(int x) {

        String number = Integer.toString(x);
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                return false;
            }
        }

        return true;

    }

    // Solution 2: get digit by digit and create the reversed number
    public static boolean isPalindromeNoString(int x) {
        int intReversed = 0;
        int original = x;
        while (original > 0) {
            int remainder = original % 10;
            original /= 10;
            intReversed = (intReversed * 10) + remainder;
        }

        return (x == intReversed);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(-3));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(5));
    }

}
