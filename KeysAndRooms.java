/*

Leetcode Problem 841: Keys and Rooms (Medium)

There are N rooms and you start in room 0.
Each room has a distinct number in 0, 1, 2, ..., N-1,
and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i],
and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 
You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Complexity for this solution:
...

*/

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Stack<Integer> current = new Stack<>();
        current.add(0);

        while (!current.isEmpty()) {
            List<Integer> keys = rooms.get(current.pop());
            for (int key : keys) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    current.add(key);
                }
            }
        }

        return visited.size() == rooms.size();

    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList());
        rooms.add(Arrays.asList(1));
        System.out.println(canVisitAllRooms(rooms));
    }

}
