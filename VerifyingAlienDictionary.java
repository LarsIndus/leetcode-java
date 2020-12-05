/*

Leetcode Problem 953: Verifying an Alien Dictionary (Easy)

In an alien language, surprisingly they also use english lowercase letters,
but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographicaly in this alien language.

Complexity for this solution:
O(nm) time with n number of words and m maximum word length,
O(1) space (hash map has at most 26 entries)

*/

import java.util.Map;
import java.util.HashMap;

public class VerifyingAlienDictionary {
    
    public static boolean isAlienSorted(String[] words, String order) {
        
        // use a hash map for the ordering to access in constant time
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        // compare adjacent words --> O(n)
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int smallerLength = Math.min(word1.length(), word2.length());

            // compare character by character --> O(m) --> O(nm) in total
            for (int j = 0; j < smallerLength; j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);
                // the comparisons in here happen in constant time as we use a hash  map --> still O(nm)
                if (orderMap.get(char1) > orderMap.get(char2)) {
                    // case 1: wrong ordering
                    return false;
                } else if (orderMap.get(char1) < orderMap.get(char2)) {
                    // case 2: correct ordering --> exit inner loop and compare next two words
                    break;
                } else if (j == smallerLength - 1 && word1.length() > word2.length()) {
                    // all letters have been the same up to here; second word has to be as least as long as first
                    return false;
                }
            }

        }

        // all checks successful
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        /* String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz"; */

        /* String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz"; */

        System.out.println(isAlienSorted(words, order));
    }

}
