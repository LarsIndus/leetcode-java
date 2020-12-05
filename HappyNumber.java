/*

Leetcode Problem 202: Happy Number (Easy)

Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Complexity for this solution:
...

*/

import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }

            if (seen.contains(sum)) {
                return false;
            }

            seen.add(sum);
            n = sum;
        }

        return true;

    }

    public static void main(String[] args) {
        int[] nums = {19, 24, 0, -1, 1};
        for (int n : nums) {
            System.out.println(n + ": " + isHappy(n));
        }
    }
}
