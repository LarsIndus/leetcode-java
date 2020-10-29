/*

Leetcode Problem 403: Frog Jump (Hard)

A frog is crossing a river. The river is divided into x units
and at each unit there may or may not exist a stone.
The frog can jump on a stone, but it must not jump into the water.

Given a list of 'stones' positions (in units) in ascending order,
determine if the frog is able to cross the river by landing on the last stone.
Initially, the frog is on the first stone
and assume the first jump must be 1 unit.

If the frog's last jump was k units,
then its next jump must be either k - 1, k or k +1 units.
Not that the frog can only jump in the forward direction.

Note:

    - The number of stones is >= 2 and < 1,100.
    - Each stone's positon will be a non-negative integer < 2^31.
    - The first stone's position is always 0.

*/

import java.util.HashSet;
import java.util.Stack;

public class FrogJump {

    public static boolean canCross(int[] stones) {

        // only for optimization
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - stones[i - 1] > i) {
                System.out.println("Exited early");
                return false;
            }
        }

        HashSet<Integer> stonePositions = new HashSet<>();
        for (int stone : stones) {
            stonePositions.add(stone);
        }

        int lastStone = stones[stones.length - 1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);

        while (!positions.isEmpty()) {
            int position = positions.pop();
            int jumpDistance = jumps.pop();
            for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
                if (i <= 0) continue;
                int nextPosition = position + i;
                if (nextPosition == lastStone) {
                    return true;
                } else if (stonePositions.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }

        System.out.println("Exited after main loop");
        return false;

    }

    public static void main(String[] args){
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));
    }
}
