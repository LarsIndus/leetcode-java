/*

Leetcode Problem 948: Bag of Tokens (Medium)

You have an initial power of P, an initial score of 0,
and a bag of tokens where tokens[i] is the value of the ith token (0-indexed).

Your goal is to maximize your total score by potentially playing each token in one of two ways:

    - If your current power is at least tokens[i], you may play the ith token face up,
      losing token[i] power and gaining 1 score.
    - If your current score is at least 1, you may play the ith token face down,
      gaining token[i] power and losing 1 score.

Each token may be played at most once and in any order. You do not have to play all the tokens.

Return the largest possible score you can achieve after playing any number of tokens.

Complexity for this solution:
O(n log n) time (because of sorting), O(1) space

*/

import java.util.Arrays;

public class BagOfTokens {

    public static int getScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int maxPoints = 0;
        int points = 0;
        int low = 0;
        int high = tokens.length - 1;

        while (low <= high) {
            if (P >= tokens[low]) {
                points++;
                P -= tokens[low++];
                maxPoints = Math.max(maxPoints, points);
            } else if (points > 0) {
                points--;
                P += tokens[high--];
            } else {
                return maxPoints;
            }
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int P = 200;
        System.out.println(getScore(tokens, P));
    }
}
