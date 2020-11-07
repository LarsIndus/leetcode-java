/*

Leetcode Problem 293: Flip Game (Easy)

You are playing the following flip game with your friend:
Given a string that contains only the characters '+' and '-',
you and your friend take turns to flip two consecutive "++" into "--".
The game ends when a person can no longer make move
and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.
If there is no valid move, return an empty list.

Complexity for this solution:
O(n^2) time and O(n) space

*/

import java.util.List;
import java.util.ArrayList;

public class FlipGame {

    // Solution 1: My first approach
    public static List<String> nextPossibleMoves1(String s) {
        List<String> possibleStates = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return possibleStates;
        }

        char[] strArr = s.toCharArray();
        char[] nextState = new char[strArr.length];

        for (int i = 0; i < strArr.length - 1; i++) {
            if (strArr[i] == '+' && strArr[i + 1] == '+') {
                for (int j = 0; j < nextState.length; j++) {
                    nextState[j] = strArr[j];
                }
                nextState[i] = '-';
                nextState[i + 1] = '-';
                possibleStates.add(String.valueOf(nextState));
            }
        }

        return possibleStates;
    }

    // Solution 2: More concise code
    public static List<String> nextPossibleMoves2(String s) {
        List<String> possibleStates = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            // find index of "++" starting at i
            int nextIndex = s.indexOf("++", i);

            // if none was found, return the current list
            if (nextIndex == -1) return possibleStates;

            // otherwise, build the next state and add it to the list
            String nextState = s.substring(0, nextIndex) + "--" + s.substring(nextIndex + 2);
            possibleStates.add(nextState);

            // start searching again one index after the last occurrence
            i = nextIndex + 1;
        }

        return possibleStates;
    }

    public static void main(String[] args) {
        String s = "++++++";
        List<String> nextPossibleMoves = nextPossibleMoves2(s);
        for (String move : nextPossibleMoves) {
            System.out.println(move);
        }
    }
}
