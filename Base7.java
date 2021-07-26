/*

Leetcode Problem 504: Base 7 (Easy)

Given an integer num, return a string of its base 7 representation.

Complexity for this solution:
O(log n) time (base 7) and O(1) space

*/

public class Base7 {

    // Solution 1: My initial approach
    public static String convertToBase7(int num) {
        if (num < 0) return '-' + convertToBase7(-num);
        if (num == 0) return "0";

        // Find the highest power of 7 that fits into the number.
        int highestPower = 0;
        while (Math.pow(7, highestPower) < num) highestPower++;
        if (Math.pow(7, highestPower) > num) highestPower--;
        
        // Build a string by calculating the digits one by one.
        StringBuilder sb = new StringBuilder();
        for (int power = highestPower; power >= 0; power--) {
            int count = 0; // How often does the current power fit?
            double value = Math.pow(7, power);
            while (num >= value) {
                num -= value;
                count++;
            }
            sb.append((char)(count + '0'));
        }

        return sb.toString();
    }

    // Solution 2: recursion
    public static String convertTo7(int num) {
        if (num < 0) return '-' + convertTo7(-num);
        if (num < 7) return num + "";
        return convertTo7(num / 7) + num % 7;
    }

    // Solution for a general base
    public static String convertToBase(int num, int base) {
        if (num < 0) return '-' + convertToBase(-num, base);
        if (num < base) return num + "";
        return convertToBase(num / base, base) + num % base;
    }

    public static void main(String[] args) {
        int[] nums = {0, 8, 50, 100, -7, 7, 49, 210};
        for (int num : nums) {
            System.out.println(num + ": " + convertToBase7(num));
        }
    }
}