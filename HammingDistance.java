/*

Leetcode Problem 461: Hamming Distance (Easy)

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Complexity for this solution:
O(log(x^y)) time and O(1) space

*/

public class HammingDistance {
    
    public static int hammingDistance(int x, int y) {
        int result = 0;

        // Calculate XOR: bit representation has a 1 where x and y have different bits and 0 if bits coincide.
        int temp = x^y;
        // Add the bits to the result, starting from the right and then shift one bit to the right.
        while (temp > 0) {
            result += temp & 1; // could also do result += temp % 2
            temp >>= 1; // could also do temp /= 2
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }
}
