/*

Leetcode Problem 763: Partition Labels (Medium)

A string s of lowercase letters is given.
We want to partition this string into as many parts as possible
so that each letter appears in at most one part,
and return a list of integers representing the size of these parts.

Complexity for this solution:
O(n) time, O(1) space

*/

import java.util.List;
import java.util.ArrayList;

public class PartitionLabels {

    public static List<Integer> getLabels(String s) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndexes = new int[26]; // only 26 possible characters --> constant space

        // get last occurrence for each letter
        for (int i = 0; i < s.length(); i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < s.length()) {
            // get last index of first letter
            int end = lastIndexes[s.charAt(i) - 'a'];

            // check whether we have to do the partition later
            int j = i;
            while (j != end) {
                end = Math.max(end, lastIndexes[s.charAt(j++) - 'a']);
            }

            partitionLengths.add(j - i + 1);
            i = j + 1;
        }

        return partitionLengths;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        // expected: 9, 7, 8 (partition: ababcbaca, defegde, hijhklij)
        List<Integer> partitionLengths = getLabels(s);
        for (int i = 0; i < partitionLengths.size(); i++) {
            System.out.print(partitionLengths.get(i) + " ");
        }
    }
}
