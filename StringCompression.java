/*

Leetcode Problem 443: String Compression (Medium)

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

    - If the group's length is 1, append the character to s.
    - Otherwise, append the character followed by the group's length.
    
The compressed string s should not be returned separately,
but instead be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

Complexity for this solution:
O(n) time (n length of string), O(1) space

*/

public class StringCompression {

    public static int compress(char[] chars) {
        int pos = 0;
        int i = 0;

        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            chars[pos++] = chars[i];

            int count = j - i;
            if (count > 1) { 
                char[] temp = ("" + count).toCharArray();
                for (char digit : temp) {
                    chars[pos++] = digit;
                }
            }
            
            i = j;
        }

        System.out.print("Altered string: ");
        for (int l = 0; l < chars.length; l++) {
            System.out.print(chars[l]);
        }
        System.out.println();

        return pos;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        System.out.println("Length of compression: " + compress(chars));
    }
}
