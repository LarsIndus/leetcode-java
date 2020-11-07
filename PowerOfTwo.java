/*

Leetcode Problem 231: Power of Two (Easy)

Given an integer n, write a function to determine if it is a power of two.

*/

public class PowerOfTwo {
    
    // Solution 1: Recursive approach, O(log n) time complexity
    public static boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        else if (n == 1) return true;
        else if (n % 2 != 0) return false;
        else return isPowerOfTwo1(n / 2);
    }

    // Solution 2: use base 2 logarithm for an easy solution
    public static boolean isPowerOfTwo2(int n) {
        double x = Math.log(n) / Math.log(2);
        return x == (int)x;
    }

    /* Solution 3: Iterative approach
    Calculate powers up to n and check whether the last power equals n.
    */
    public static boolean isPowerOfTwo3(int n) {
        long power = 1;
        while (power < n) power *= 2;
        return power == n;
    }

    /* Solution 4: Iterative approach
    Divide by two as long as possible and check whether the end result is 1.
    */
    public static boolean isPowerOfTwo4(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    /* Solution 5: Bitwise Approach
    Claim: n & (n - 1) = 0 iff n is a power of two.
    Proof: Note that if n is a power of two, we have the following binary representations:

    n           : 1000000...
    n - 1       : 0111111...
    n & (n - 1) : 0000000... (representing 0)

    If n is not a power of two, the highest bit is not touched when subtracting 1,
    so the result will have a leading 1 and is therefore not equal to 0.
    Thus, we can simpy check whether n & (n -1) equals 0.
    */
    public static boolean isPowerOfTwo5(int n) {
        return (n > 0 && (n & n - 1) == 0);
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 0, 1, 2, 8, 15, 256};
        for (int n : numbers) {
            System.out.println(n + ": " + isPowerOfTwo1(n));
        }
    }
}
