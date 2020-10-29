/*

Leetcode Problem 72: Edit Distance (Hard)

Given two words word1 and word2, find the minimum number of operations
required to convert word1 to word2.
You have the following 3 operations permitted on a word:

    1. Insert a character
    2. Delete a character
    3. Replace a character

Complexity for this solution:
...

*/

public class EditDistance {

    public static int getDistance(String word1, String word2) {

        char[] arrWord1 = word1.toCharArray();
        char[] arrWord2 = word2.toCharArray();
        int length1 = arrWord1.length;
        int length2 = arrWord2.length;
        int[][] mat = new int[length2 + 1][length1 + 1];

        for (int i = 0; i < length2 + 1; i++) {
            mat[i][0] = i;
        }

        for (int j = 0; j < length1 + 1; j++) {
            mat[0][j] = j;
        }

        for (int i = 1; i < length2 + 1; i++) {
            for (int j = 1; j < length1 + 1; j++) {
                if (arrWord1[j - 1] == arrWord2[ i - 1]) {
                    mat[i][j] = mat[i - 1][j - 1];
                } else {
                    mat[i][j] = Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1;
                }
            }
        }

        return mat[length2][length1];

    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        
        System.out.println(String.format(
            "Edit distance of '%s' and '%s': " + getDistance(word1, word2), word1, word2
            )
        );
    }
}
