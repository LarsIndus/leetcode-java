/*

Leetcode Problem 58: Length of Last Word (Easy)

Given a string s consists of some words separated by spaces,
return the length of the last word in the string.
If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

Complexity for this solution:
O(n) time and O(1) space

*/

public class LengthOfLastWord {
    
    // Solution 1:
    // Use two pointers to find first and last character of the last word
    public static int lengthOfLastWord1(String s) {
        // Find last character of last word
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;

        // Find first character of last word
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;

        return end - start;

    }

    // Solution 2:
    // Traverse the string backwards and count non-space characters
    public static int lengthOfLastWord2(String s) {
        int length = 0;
		
		// We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
				//  Did we already start to count a word? If so, we have the length of the last word.
                if (length > 0) return length;
            }
        }
        return length;
    }

    public static void main(String[] args)  {
        String[] str = {"Hello World", "Hello World  ", "", "  ", " Hello", "Hello"};
        for (String s : str) {
            System.out.println(s + ": " + lengthOfLastWord1(s));
        }
    }
}