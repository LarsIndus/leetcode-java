/*

Leetcode Problem 17: Letter Combinations of a Phone Number (Medium)

Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Complexity for this solution:
Time and space complexity is O(4^n) (as there are at most 4 characters on a number button).

*/

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumberCombinations {

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> sol = new ArrayList<String>();
        if (digits.length() == 0) {
            return sol;
        }
        letterCombinationsHelper(digits, "", sol);
        return sol;
    }

    private static void letterCombinationsHelper(String digits, String cur, ArrayList<String> sol) {
        if (digits.length() == 0) {
            sol.add(cur);
            return;
        }

        String possibleChars = digitToLetters(digits.charAt(0));
        for (int i = 0; i < possibleChars.length(); i++) {
            char temp = possibleChars.charAt(i);
            cur += temp;
            letterCombinationsHelper(digits.substring(1, digits.length()), cur, sol);
            cur = cur.substring(0, cur.length() - 1);

        }
    }

    private static String digitToLetters(char digit) {
        HashMap<Character, String> mapping = new HashMap<Character, String>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        return mapping.get(digit);
    }

    public static void main(String[] args) {
        String digits = "283";
        System.out.println(PhoneNumberCombinations.letterCombinations(digits));
    }
}
