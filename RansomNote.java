/*

Leetcode Problem 383: Ransom Note (Easy)

Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines;
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Complexity for this solution:
O(n + m) time with n, m being the lengths of the strings and O(1) space (only 26 letters).

*/

public class RansomNote {
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        // count available letters
        int[] availableLetters = new int[26];
        for (char c : magazine.toCharArray()) {
            availableLetters[c - 'a']++;
        }

        // substract letters we need for the ransom note
        for (char c : ransomNote.toCharArray()) {
            // if the count in magazine is already 0, we cannot build the note
            if (availableLetters[c - 'a'] == 0) {
                return false;
            }
            availableLetters[c - 'a']--;
        }

        // all checks passed, we can build the note
        return true;

    }

    public static void main(String[] args) {
        String ransomNote = "aaca";
        String magazine = "aabaczz";
        System.out.println(canConstruct(ransomNote, magazine));
    }


}
