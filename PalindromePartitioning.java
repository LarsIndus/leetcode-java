/*

Leetcode Problem 131: Palindrome Partitioning (Medium)

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitionings of s.

A palindrome string is a string that reads the same backward as forward.

Complexity for this solution:
O(n * 2^n) time, O(n) space (not considering the space for the result but just recursion)

*/

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
    
    // backtracking approach; most logic is inside the helper function
    public static List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        helper(partitions, new ArrayList<>(), s,  0);
        return partitions;
    }

    // helper function to find palindromic substrings
    public static void helper(List<List<String>> partitions, List<String> current, String s, int index) {
        // if we have processed the whole string, add current partition to our result
        if (index == s.length()) {
            // Be careful to pass a copy of current to our result list, not the original!
            partitions.add(new ArrayList<>(current));
            return;
        }

        // Go through the next characters and call the helper recursively if the substring is a palindrome;
        // after that delete last element (backtracking).
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
               current.add(s.substring(index, i + 1));
               helper(partitions, current, s, i + 1);
               current.remove(current.size() - 1);
            }
         }

    }

    // helper function to check whether a string is a palindrome
    public static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}