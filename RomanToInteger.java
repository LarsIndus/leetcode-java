/*

Leetcode Problem 13: Roman to Integer (Easy)

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

For example, 2 is written as II in Roman numeral, just two one's added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

    - I can be placed before V (5) and X (10) to make 4 and 9. 
    - X can be placed before L (50) and C (100) to make 40 and 90. 
    - C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

Complexity for this solution:
O(n) time and O(1) space

*/

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {
    
    public static int romanToInt(String s) {
        // map roman numerals to numbers (O(1) space as we have only 7 entries)
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        // If a letter is followed by a letter that represents a larger number, substract. Else, add.
        // Process all letters but the last.
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }

        // The last letter is always added.
        result += map.get(s.charAt(s.length() - 1));

        return result;
    }

    public static void main(String[] args) {
        String[] roman = {"I", "III", "IV", "CDLX", "MCMXCIV"};
        for (String s : roman) {
            System.out.println(s + ": " + romanToInt(s));
        }
    }
}