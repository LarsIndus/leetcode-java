/*

Leetcode Problem 345: Reverse Vowels of a String (Easy)

Write a function that takes a string as input and reverse only the vowels of a string.

Complexity for this solution:
O(n) time and space

*/

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {

            while (i < j && !vowels.contains(arr[i])) {
                i++;
            }
            while (i < j && !vowels.contains(arr[j])) {
                j--;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode", "klbnrt", ""};
        for (String s : words) {
            System.out.println(reverseVowels(s));
        }
    }
}
