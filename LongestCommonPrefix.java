/*

Leetcode Problem 14: Longest Common Prefix (Easy)

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Complexity for this solution:
O(m * n) time and O(m) space where m is the length of the shortest string
and n is the number of strings in the list.

*/

public class LongestCommonPrefix {
    
    public static String longestCommonPrefix(String[] strs) {

        // initial check / optimization
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder result = new StringBuilder();

        // find the shortest string length in the array
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return result.toString();
                }
            }
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
