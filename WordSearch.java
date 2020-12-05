/*

Leetcode Problem 79: Word Search (Medium)

Given an m x n board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells,
where "adjacent" cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Complexity for this solution:
O(ns) time where n is the number of cells in the grid and s is the length of the word.
O(n) space because of recursion

*/

public class WordSearch {

    // backtracking approach
    public static boolean exists(char[][] board, String word) {

        // sanity check/optimization
        if (word.length() > board.length * board[0].length || board == null || board.length == 0 || word == null) {
            return false;
        }

        // start looking for the first letter on the board;
        // if found look for next letters recursively (backtracking)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // the first condition can be omitted, but we can prevent unnecessary function calls like that
                if (board[i][j] == word.charAt(0) && findLetter(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        // word not found
        System.out.println("Could not find the word '" + word + "'.");
        return false;

    }

    // DFS-like function: look for the next letter in adjacent cells until the word has been found
    // or next letter cannot be found anymore
    public static boolean findLetter(char[][] board, int i, int j, String word, int strIdx) {

        // the whole word has been found
        if (strIdx == word.length()) {
            System.out.println("Word has been found.");
            return true;
        }

        // which letter are we looking for next
        char curChar = word.charAt(strIdx);

        // if cell is not on the board or the letter is not the one we are looking for, return false
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != curChar) {
            return false;
        }

        // mark the current cell as already visited, so we don't use it twice
        // increment strIdx in order to look for the next letter in subsequent recursive calls
        board[i][j] = '#';
        strIdx++;
        System.out.println("Found letter '" + curChar + "' at position (" + i + ", " + j + ")");
        System.out.println("So far: " + word.substring(0, strIdx));

        // check if the next letter occurs in one of the adjacent cells
        if (findLetter(board, i - 1, j, word, strIdx) || findLetter(board, i + 1, j, word, strIdx) ||
            findLetter(board, i, j - 1, word, strIdx) || findLetter(board, i, j + 1, word, strIdx)) {
            return true;
        }

        // if next letter is not found, we have to backtrack:
        // decrement strIdx and write the original letter into the cell again (can be used later)
        // return false to end recursion
        strIdx--;
        board[i][j] = curChar;

        System.out.println("Backtracking ...");
        System.out.println("So far: " + word.substring(0, strIdx));
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String[] words = {"SEEC", "ABFA"};
        for (String word : words) {
            System.out.println("Word to find: " + word);
            exists(board, word);
            System.out.println();
        }
    }

}
