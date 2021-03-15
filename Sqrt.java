/*

Leetcode Problem 69: Sqrt(x) (Easy)

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated,
and only the integer part of the result is returned.

Complexity for this solution:
O(log n) time complexity for solution 1 and 2 (Newton and Binary Search),
O(sqrt(n)) for brute force. O(1) space complexity for all solutions.

*/

public class Sqrt {
    
    // Solution 1: Newton's Method (O(log x) time complexity)
    public static int mySqrt1(int x) {
        long root = x;
        while (root * root > x) root = (root + x / root) / 2;
        return (int)root;
    }

    // Solution 2: Binary Search (O(log x) time complexity)
    public static int mySqrt2(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left < right) { 
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) { // Found the result
                return mid;
            }
            else if (mid > x / mid) { // Keep checking the left part
                right = mid;
            } else {
                left = mid + 1; // Keep checking the right part
            }
        }
        return left;
    }

    // Solution 3: Brute Force (O(sqrt(x)) time complexity)
    public static int mySqrt3(int x) {
        int root = 0;
        while (root * root < x) root++;
        return (root * root == x) ? root : root - 1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 8, 25, 30};
        for (int x : numbers) {
            System.out.println("Square root of " + x + ": " + mySqrt2(x));
        }
    }
}