/*

Leetcode Problem 1221: Split a String in Balanced Strings (Easy)

Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
Given a balanced string s, split it in the maximum amount of balanced strings.
Return the maximum amount of split balanced strings.

Complexity for this solution:
O(n) time and O(1) space

*/

public class SplitStringInBalancedStrings {
    
    // Greedily split the string
    public static int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;

        // + 1 for 'L' and - 1 for 'R'
        for (char c : s.toCharArray()) {
            if (c == 'L') balance++;
            else if (c == 'R') balance--;

            // When temp == 0, we have a balanced substring.
            if (balance == 0) count++;
        }

        // If temp is not 0, the whole string is not balanced, i.e., cannot be split into balanced substrings.
        // (LeetCode excludes this case, but I added it anyway.)
        if (balance != 0) count = 0;
        
        return count;
    }

    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }
}
