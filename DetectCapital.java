/*

Leetcode Problem 520: Detect Capital (Easy)

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    1. All letters in this word are capitals, like "USA".
    2. All letters in this word are not capitals, like "leetcode".
    3. Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

Complexity for this solution:
O(n) time and space

*/

public class DetectCapital {
    
    /*
    Solution 1 (my initial solution):
    Might be too laborious.

    O(n) time and space complexity
    */
    public static boolean detectCapitalUse1(String word) {
        // initial check
        if (word == null || word.length() < 2) return true;

        char[] charArr = word.toCharArray();

        // There are at least two characters, see whether they are upper or lower case.
        boolean isUpperFirst = Character.isUpperCase(charArr[0]);
        boolean isUpperSecond = Character.isUpperCase(charArr[1]);

        // Traverse the character's starting from the second one.
        for (int i = 1; i < charArr.length; i++) {
            // If the first is lower case, every following character has to be likewise.
            if (!isUpperFirst) {
                if (Character.isUpperCase(charArr[i])) {
                    return false;
                }
            } else { // The first character is upper case
                // If the second is upper case as well, every following character has to be likewise.
                if (isUpperSecond) {
                    if (Character.isLowerCase(charArr[i])) {
                        return false;
                    }
                } else {
                    // If the second is lower case, every following character has to be likewise.
                    if (Character.isUpperCase(charArr[i])) {
                        return false;
                    }
                }
            }
        }

        // All checks successful.
        return true;
    }


    /*
    Solution 2:
    The string is correctly capitalized if either:

        - It's shorter than 2 characters.
        - If it's all upper case.
        - If it's all lower case or from position 1 onward there are only lowercase letters.

    O(n) time and space complexity
    (space complexity due to the toLowerCase() and toUpperCase() methods)
    */
    public static boolean detectCapitalUse2(String word) {
        if (word == null || word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        return false;
    }


    /*
    Solution 3:
    Check whether the first character is upper case or lower case.
    Then count all upper case letters AFTER the first one.
    If the first was upper case, the word is correctly capitalized if the count is
    word.length() - 1 or 0 (i.e., all or none of the following characters are upper case).
    If the first was lower case, the word is correctly capitalized if the count is 0
    (i.e., all characters are lower case).

    O(n) time and space complexity
    (space complexity due to the toLowerCase() and toUpperCase() methods)
    */
    public static boolean detectCapitalUse3(String word) {
        if (word == null || word.length() < 2) return true;

        boolean isCap = Character.isUpperCase(word.charAt(0));
        // count upper case letters AFTER the first character
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) count++;
        }

        return isCap ? (count == word.length() - 1 || count == 0) : count == 0;
    }

    public static void main(String[] args) {
        String[] words = {"USA", "leetcode", "Google", "FlaG", "", null, "aG", "Ga", "US", "ba"};
        for (String word : words) {
            System.out.println(word + ": " + detectCapitalUse1(word));
        }
    }
}