/*

Leetcode Problem 187: Repeated DNA Sequences (Medium)

All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T',
for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings)
that occur more than once in a DNA molecule.

Complexity for this solution:
O(n) time (note that the length of subsequcnes is the constant 10) and space

*/

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class RepeatedDNASequences {

    // Solution 1: My first approach
    public static List<String> findRepeatedDNASequences(String s) {
        List<String> repeatedSubsequences = new ArrayList<>();
        if (s == null || s.length() <= 10) return repeatedSubsequences;

        for (int i = 0; i <= s.length() - 10; i++) {
            String subsequence = s.substring(i, i + 10); // constant length --> constant time and space
            // if current subsequence is seen for the first time, check if it reoccurs later on
            if (!repeatedSubsequences.contains(subsequence)) {
                int nextIndex = s.indexOf(subsequence, i + 1);
                if (nextIndex > -1) {
                    repeatedSubsequences.add(subsequence);
                }
            }
        }

        return repeatedSubsequences;
    }

    /* Solution 2: More efficient solution
    Use a hashmap to avoid duplicates in a more elegant way than above.
    Also, use a string builder as it is more efficient than the substring method from above.
    */
    public static List<String> findRepeatedDNASequences2(String s) {
        if (s == null || s.length() <= 10) return new ArrayList<>();

        HashSet<String> subsequences = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i <= s.length() - 10; i++) {
            String subsequence = builder.substring(i, i + 10);
            if (subsequences.contains(subsequence)) {
                result.add(subsequence);
            }
            subsequences.add(subsequence); // no duplicates here!
        }


        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> sequences = findRepeatedDNASequences2(s);
        for (String sequence : sequences) {
            System.out.println(sequence);
        }
    }
}
