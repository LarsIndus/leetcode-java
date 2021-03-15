/*

Leetcode Problem 1167: Minimum Cost to Connect Sticks (Medium)

You have some sticks with positive integer lengths.

You can connect any two sticks of lenghts x and y into one stick by paying a cost of x + y.
You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Complexity for this solution:
O(n log n) time and O(n) space

*/

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    /*
    Min-Heap approach:
    If we combine to sticks, say x + y, and later combine the result with another stick of length z,
    we pay the cost x + y again and pay z on top.
    Thus, we want to have the most expensive sticks as late as possible,
    i.e., we start with the cheapest two sticks, then take the next cheapest and so on (greedy approach).
    An easy way to get the cheapest sticks is to use a min-heap (n log n time).
    */
    public static int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) minHeap.add(stick);

        while (minHeap.size() > 1) {
            int sum = minHeap.remove() + minHeap.remove();
            cost += sum;
            minHeap.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] sticks = {1, 8, 3, 5};
        System.out.println(connectSticks(sticks));
    }
    
}