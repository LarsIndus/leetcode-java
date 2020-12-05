/*

Leetcode Problem 286: Walls and Gates (Medium)

You are given a m x n 2D grid initialized with three possible values:

    1. -1  : a wall or obstacle
    2. 0   : a gate
    3. INF : Infinity means an empty room. It is represented by 2^31 - 1 = 2147483647
             (i.e., the distance to a gate is less than 2147483647).

Fill each empty room with the distance to its nearest gate.
If it is impossible to reach a gate, it should be filled with INF.

Complexity for this solution:
O(N^2) time (N being the number of cells) and O(N) space (recursion)

*/

public class WallsAndGates {

    /* 
    Traverse through the grid and look for a gate.
    Every time we find a gate, we do a dfs to calculate the distance from that gate
    to all cells that are accessible starting from that gate.
    We pass a starting distance of 0 to the function (as we start from a gate)
    and this distance is incremented every time the function calls itself recursively.
    */
    public static void wallsAndGatesDFS(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    public static void dfs(int[][] rooms, int i, int j, int distance) {
        /* If out of bounds, hit a wall or current distance is greater
        than an alredy recorded distance, stop here.
        Note that the last two conditions can both be checked by rooms[i][j] < distance. */
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] == -1
            || rooms[i][j] < distance) {
            return;
        }

        rooms[i][j] = distance;

        // dfs on adjacent cells, distance is incremented by 1
        dfs(rooms, i - 1, j, distance + 1);
        dfs(rooms, i + 1, j, distance + 1);
        dfs(rooms, i, j - 1, distance + 1);
        dfs(rooms, i, j + 1, distance + 1);

    }

    public static void main(String[] args) {
        int INF = 2147483647;
        int[][] rooms = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF},
        };

        wallsAndGatesDFS(rooms);
        for (int[] row : rooms) {
            for (int n : row) {
                if (n < 0) {
                    System.out.print(" " + n);
                } else {
                    System.out.print("  " + n);
                }
            }
            System.out.println();
        }
    }
}
