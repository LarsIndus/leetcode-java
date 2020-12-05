/*

Leetcode Problem 389: Pascal's Triangle II (Easy)

Given an integer k, return the kth row of the Pascal's triangle.
Notice that the row index starts from 0.

Follow up:
Could you optimize your algorithm to use only O(k) extra space?

Complexity for this solution:
O(k^2) time and O(k) space

*/

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangleII {
    
    public static List<Integer> getRow(int k) {

        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }

    public static void main(String[] args) {
        int k = 1;
        List<Integer> row = getRow(k);
        for (int n : row) {
            System.out.print(n);
        }
    }
}
