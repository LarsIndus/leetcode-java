/*

Leetcode Problem 917: Reverse Only Letters (Easy)

Given a string S, return the "reversed" string where all characters that are not a letter
stay in the same place, and all letters reverse their positions.

Complexity for this solution:
O(n) time and space

*/

import java.util.Stack;

public class ReverseOnlyLetters {

    // Solution 1: Standard approach traversing the string
    public static String reverseOnlyLetters1(String S) {
        char[] strArr = S.toCharArray();
        int i = 0;
        int j = S.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetter(strArr[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(strArr[j])) {
                j--;
            }

            char temp = strArr[i];
            strArr[i++] = strArr[j];
            strArr[j--] = temp;
        }

        return new String(strArr);
    }

    // Solution 2: Using a stack
    public static String reverseOnlyLetters2(String S) {
        Stack<Character> letters = new Stack<Character>();
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                ans.append(letters.pop());
            }
            else {
                ans.append(c);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String S = "a-bC-dEf-ghIj";
        System.out.println("Solution 1: " + reverseOnlyLetters1(S));
        System.out.println("Solution 2: " + reverseOnlyLetters2(S));
    }
}
