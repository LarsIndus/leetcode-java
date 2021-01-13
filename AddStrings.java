/*

Leetcode Problem 415: Add Strings (Easy)

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    1. The length of both num1 and num2 is < 5100.
    2. Both num1 and num2 contains only digits 0-9.
    3. Both num1 and num2 does not contain any leading zero.
    4. You must not use any built-in BigInteger library or convert the inputs to integer directly.

Complexity for this solution:
O(m + n) time and O(max(m, n)) where m and n are the lengths of the strings.

*/

public class AddStrings {

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int val1 = (i >= 0) ? arr1[i--] - '0' : 0;
            int val2 = (j >= 0) ? arr2[j--] - '0' : 0;

            int sum = val1 + val2 + carry;

            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "1";

        System.out.println(addStrings(num1, num2));
    }
}
