/*

Leetcode Problem 819: Most Common Word (Easy)

Given a string paragraph and a string array of the banned words banned,
return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Complexity for this solution:
O(n + m) time and space

*/

import java.util.*;

public class MostCommonWord {
    
    public static String mostCommonWord(String paragraph, String[] banned) {
        // Remove everything that is not a letter or space, convert to lowercase and split into words.
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        // Create a set of banned words, to make excluding banned words more efficient later on.
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned)); // O(m) time (?)

        // count word frequencies in a map
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            // only add if the word is not banned - O(1) operation because of set!
            if (!bannedWords.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // find the most common word in the map
        String mostCommon = freq.entrySet().stream()
            .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
            .get()
            .getKey();

        // alternative to get the most common word
        /* int max = 0;
        String mostCommon = "";
        for (String str : freq.keySet()) {
            if (freq.get(str) > max) {
                max = freq.get(str);
                mostCommon = str;
            }
        } */
        
        return mostCommon;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}