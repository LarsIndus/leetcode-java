/*

Leetcode Problem 66: Plus One (Easy)

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list,
and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Complexity for this solution:
O(n) time and space complexity
(Worst case! If number does not contain only 9s, no additional space is needed)

*/

public class PlusOne {
    
    public static int[] plusOne(int[] digits) {
        
        // loop through the digits starting from the back
        for (int i = digits.length - 1; i >= 0; i--) {
            // if there is a digit less than 9, increment it and immediately return
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            // if the digit is 9, it becomes 0
            digits[i] = 0;
        }

        // if the above loop finished without returning, every digit was a 9
        //  --> set up a new array with one more digit and set the first digit to 1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        
        return result;

    }

    public static void main(String[] args) {
        int[] digits = {9, 9};
        int[] plusOne = plusOne(digits);
        for (int k : plusOne) {
            System.out.print(k);
        }
    }
}
