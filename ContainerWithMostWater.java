/*

Leetcode Problem 11: Container With Most Water (Medium)

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai),
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
Find two lines, which, together with the x-axis forms a container,
such that the container contains the most water.

Notice that you may not slant the container.

Complexity for this solution:
O(n) (second solution)

*/

public class ContainerWithMostWater {

    // Solution 1: Naive approach with O(n^2) complexity
    public static int maxAreaNaive(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int smaller = Math.min(height[i], height[j]);
                max = Math.max(max, (j - i) * smaller);
            }
        }

        return max;
    }

    // Solution 2: in linear time
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int smaller = Math.min(height[i], height[j]);
            max = Math.max(max, (j - i) * smaller);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
