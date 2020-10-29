/*

Leetcode Problem 455: Assign Cookies (Easy)

Assume you are an awesome parent and want to give your children some cookies.
But, you should give each child at most one cookie.
Each child i has a greed factor g[i], which is the minimum size of a cookie
that the child will be content with; and each cookie j has a size s[j].
If s[j] >= g[i], we can assign the cookie j to the child i,
and the child i will be content.
Your goal is to maximize the number of your content children and output the maximum number.

Complexity for this solution:
O(n log n + m log n) time (sorting + loop), O(1) space

*/

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        // it is also possible to start with biggest cookie and most greedy child
        int smallestCookie = 0;
        int leastGreedy = 0;

        while (smallestCookie < s.length && leastGreedy < g.length) {
            if (g[leastGreedy] <= s[smallestCookie]) {
                result++;
                smallestCookie++;
                leastGreedy++;
            } else {
                smallestCookie++;
            }
        }

        return result;
        
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int [] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
    
}
