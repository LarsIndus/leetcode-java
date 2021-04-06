/*

Leetcode Problem 6: ZigZag Conversion (Medium)

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
(you may want to display this pattern in a fixed font for better legibility):

    P   A   H   N
    A P L S I I G
    Y   I   R

And then read line by line: "PAHNAPLSIIGYIR".
Write the code that will take a string and make this conversion given a number of rows.

Complexity for this solution:
O(n) time and space

*/

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();

        char[] chars = s.toCharArray();
        int index = 0; // start in the first StringBuilder (top row)
        int direction = 1; // start moving down

        for (char c : chars) {
            sbs[index].append(c);
            index += direction;
            // flip direction if we reach top or bottom row
            if (index == 0 || index == numRows - 1) {
                direction *= -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) result.append(sb);
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}