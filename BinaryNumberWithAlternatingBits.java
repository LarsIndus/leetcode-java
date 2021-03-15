/*

Leetcode Problem 693: Binary Number with Alternating Bits (Easy)

Given a positive integer, check whether it has alternating bits:
namely, if two adjacent bits will always have different values.

Complexity for this solution:
O(log n) time and O(1) space

*/

public class BinaryNumberWithAlternatingBits {
    
    // Solution 1 (my first approach)
    public static boolean hasAlternatingBits1(int n) {
        if (n == 1) return true;

        int lastBit = n % 2;
        int currentBit;
        while (n > 1) {
            // remove the last bit (either shifting bits or dividing by 2)
            n >>= 1; // can also do n /= 2
            currentBit = n % 2;
            if (lastBit == currentBit) return false;
            lastBit = currentBit;
        }

        return true;
    }

    // Solution 2:
    // https://leetcode.com/problems/binary-number-with-alternating-bits/discuss/113933/Java-super-simple-explanation-with-inline-example
    public static boolean hasAlternatingBits2(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 10, 11};
        for (int n : nums) {
            System.out.println(n + ": " + hasAlternatingBits2(n));
        }
    }
}