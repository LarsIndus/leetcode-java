/*

Leetcode Problem 844: Backspace String Compare (Easy)

Given two strings S and T, return if they are equal when both are typed into empty text editors.
# means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Complexity for this solution:
O(n + m) time and space where n, m are the lenghts of the strings.

*/

import java.util.Stack;

public class BackspaceStringCompare {

    // Solution 1: Using StringBuilders
    public static boolean backspaceCompare1(String S, String T) {
        return buildFinalString(S).equals(buildFinalString(T));
    }

    // helper for solution 1
    private static String buildFinalString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // Solution 2: Using Stacks
    public static boolean backspaceCompare2(String S, String T) {
        // Short solution directly comparing stacks:
        // return buildStack(S).equals(buildStack(T));

        // manually comparing (might be instructive)
        Stack<Character> sStack = buildStack(S);
        Stack<Character> tStack = buildStack(T);

        while (!sStack.isEmpty()) {
            char current = sStack.pop();
            if (tStack.isEmpty() || tStack.pop() != current) {
                return false;
            }
        }

        return sStack.isEmpty() && tStack.isEmpty();
    }

    // helper for solution 2
    private static Stack<Character> buildStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack;
    }

    public static void main(String[] args) {
        String S = "ab#d", T = "adc#";
        System.out.println(backspaceCompare2(S, T));
    }
}
