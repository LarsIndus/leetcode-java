/*

Leetcode Problem 20: Valid Parentheses (Easy)

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
An input string is valid if:

    - Open brackets must be closed by the same type of brackets.
    - Open brackets must be closed in the correct order.

Complexity for this solution:
Time complexity of this solution is O(n), with n being the length of the string.
Space complexity is O(n) in the worst case, O(1) otherwise.

*/

import java.util.ArrayList;

public class ValidParentheses {

    private static boolean isOpen(char parenthesis) {
        if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isSameType(char opening, char closing) {
        if (opening == '(' && closing == ')') {
            return true;
        } else if (opening == '{' && closing == '}') {
            return true;
        } else if (opening == '[' && closing == ']') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid(String input) {
        ArrayList<Character> parentheses = new ArrayList<Character>();

        for (int i = 0; i < input.length(); i++) {
            if (isOpen(input.charAt(i))) {
                parentheses.add(input.charAt(i));
            } else {
                if (parentheses.size() == 0) {
                    return false;
                }
                if (!isSameType(parentheses.remove(parentheses.size() - 1), input.charAt(i))) {
                    return false;
                }
            }
        }

        return (parentheses.size() == 0);
    }

    public static void main(String[] args) {
        String input1 = "[[({}())]]"; // valid
        String input2 = "[[({}()]]"; // not valid
        String input3 = ""; // valid (empty)
        System.out.println(ValidParentheses.isValid(input1));
        System.out.println(ValidParentheses.isValid(input2));
        System.out.println(ValidParentheses.isValid(input3));
    }
}
