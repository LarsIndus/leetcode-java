/*

Leetcode Problem 476: Number Complement (Easy)

Given a positive integer num, output its complement number.
The complement strategy is to flip the bits of its binary representation.

Complexity for this solution:
O(log n) time and O(1) space

*/

public class NumberComplement {

    // Flip bits starting from the least significant one (rightmost) and move to the left.
    public static int findComplement(int num) {
        int result = 0;
        int power = 1;
        while (num > 0) {
            // num % 2 gives the last bit; ^1 flips it
            result += (num % 2 ^ 1) * power;
            // get the next power (shift bit to the left)
            power <<= 1; // can also do power *= 2
            // Get the next bit of num (shift bit to the right)
            num >>= 1; // can also do num /= 2
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }
}