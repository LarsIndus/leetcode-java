/*

Leetcode Problem 294: Flip Game II (Medium)

You are playing the following flip game with your friend:
Given a string that contains only the characters '+' and '-',
you and your friend take turns to flip two consecutive "++" into "--".
The game ends when a person can no longer make move
and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Complexity for this solution:
O(n^n) time (!) and O(n) space (recursion).
There are probably more efficient ways to solve this problem.

*/

public class FlipGameII {
    
    public static boolean canWin(String s) {
        // initial check
        if (s == null || s.length() < 2) return false;
        
        // find the next possible move
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String nextState = s.substring(0, i) + "--" + s.substring(i + 2);
                // If the opponent cannot win after we made the move, we can guarantee a win.
                if (!canWin(nextState)) return true;
            }
        }

        // If there was always a way for the opponent to win, we cannot guarantee a win.
        return false;
    }

    

    public static void main(String[] args) {
        String s = "++++";
        System.out.println(canWin(s));
    }
}