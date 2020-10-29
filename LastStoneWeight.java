/*

Leetcode Problem 1046: Last Stone Weight (Easy)

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.
Suppose the stones have weights x and y with x <= y.
The result of this smash is:

    - If x == y, both stones are totally destroyed;
    - If x != y, the stone of weight x is totally destroyed,
      and the stone of weight y has new weight y-x.

At the end, there is at most 1 stone left.
Return the weight of this stone (or 0 if there are no stones left.)

Complexity for this solution:
O(n log n) time (remove from heap), O(n) space

*/

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    
    public static int getWeight(int[] stones) {
        /* create a max heap for the stones
        Min-Max-Heaps are implemented by priority queues.
        As the default in Java are Min-Heaps, we add Collections.reverseOrder() */
        PriorityQueue<Integer> stonesOrdered = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            stonesOrdered.add(stone);
        }

        // while there are at least two stones, compare the weights
        while (stonesOrdered.size() > 1) {
            int y = stonesOrdered.remove();
            int x = stonesOrdered.remove();
            if (x != y) {
                stonesOrdered.add(y - x);
            }
        }

        return stonesOrdered.isEmpty() ? 0 : stonesOrdered.remove();

    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(getWeight(stones));
    }

}
