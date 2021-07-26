/*

Leetcode Problem 401: Binary Watch (Easy)

A binary watch has 4 LEDs on the top which represent the hours (0-11),
and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.

Given an integer turnedOn which represents the number of LEDs that are currently on,
return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

    - For example, "01:00" is not valid. It should be "1:00".

The minute must be consist of two digits and may contain a leading zero.

    - For example, "10:2" is not valid. It should be "10:02".

Complexity for this solution:
O(1) time and space (disregaring the space for the output)

*/

import java.util.List;
import java.util.ArrayList;

public class BinaryWatch {
 
    public static List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int turnedOn = 8;
        System.out.println(readBinaryWatch(turnedOn));
    }

}