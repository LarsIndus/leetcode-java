/*

Leetcode Problem 118: Pascal's Triangle (Easy)

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

Complexity for this solution:
...

*/

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {
    
    public static List<List<Integer>> generateTriangle(int numRows) {

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // empty triangle
        if (numRows < 1) return triangle;

        // initialize first row
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);

        // build subsequent rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<Integer>();

            currentRow.add(1); // first element in every row

            // Note that for the second row, this inner loop is not run! 
            // --> not out of bounds error when grabbing elements
            for (int j = 1; j < i; j++) {
                currentRow.add(j, previousRow.get(j - 1) + previousRow.get(j));
            }

            currentRow.add(1); // last element in every row

            triangle.add(i, currentRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = generateTriangle(3);

        for (List<Integer> l1 : triangle) {
            for (int n : l1) {
                System.out.print(n + " "); 
            }
            System.out.println();
        }
    }

}
